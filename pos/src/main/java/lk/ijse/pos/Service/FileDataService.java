package lk.ijse.pos.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileDataService {

    String uploadImageFileData(MultipartFile file) throws IOException;
    byte[] getFileData(String filename) throws IOException;
}