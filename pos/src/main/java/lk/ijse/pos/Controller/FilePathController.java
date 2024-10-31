package lk.ijse.pos.Controller;

import lk.ijse.pos.Service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin("*")
@RequestMapping("/")
@RestController
public class FilePathController {


    @Autowired
    private FileDataService fileDataService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadImage = fileDataService.uploadImageFileData(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) throws IOException {
    byte[] imageData = fileDataService.getFileData(filename);
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png"))
            .body(imageData);
    }
}
