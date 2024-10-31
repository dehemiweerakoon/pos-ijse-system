package lk.ijse.pos.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    String saveImage(MultipartFile file) throws Exception;
    byte[] uploadImage(String filename) throws Exception;

}
