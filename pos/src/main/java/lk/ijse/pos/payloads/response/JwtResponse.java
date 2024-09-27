package lk.ijse.pos.payloads.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private long id;
    private String username;
    private String email;

    public JwtResponse(String token,long id,String username,String email){
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;

    }
}
