package lk.ijse.pos.Controller;

import lk.ijse.pos.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/images")
   public ResponseEntity<?> getImage(@RequestParam("image")MultipartFile file) throws Exception {
            String uploadImage = imageService.saveImage(file);
            return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
    @GetMapping("/images/{filename}")
    public  ResponseEntity<?> getImage(@PathVariable String filename) throws Exception {
        byte[] imageData = imageService.uploadImage(filename);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(imageData);
    }
}
