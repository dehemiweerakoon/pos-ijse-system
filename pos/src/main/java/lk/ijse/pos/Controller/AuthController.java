package lk.ijse.pos.Controller;

import lk.ijse.pos.Entity.User;
import lk.ijse.pos.Repository.UserRepository;
import lk.ijse.pos.Security.jwt.JwtUtils;
import lk.ijse.pos.payloads.request.LoginRequest;
import lk.ijse.pos.payloads.response.JwtResponse;
import lk.ijse.pos.payloads.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if (userRepository.existsByUsername(user.getUsername())) {

            return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken"));
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Email is Already used"));
        }
        User newuser = new User();
        newuser.setUsername(user.getUsername());
        newuser.setEmail(user.getEmail());
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newuser);

        return ResponseEntity.ok().body(new MessageResponse("User have been created"));
    }
    @PostMapping("auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User user = userRepository.findByusername(loginRequest.getUsername()).orElse(null);
        return ResponseEntity.ok().body(new JwtResponse(jwt,user.getId(), user.getUsername(),user.getEmail()));
    }
}
