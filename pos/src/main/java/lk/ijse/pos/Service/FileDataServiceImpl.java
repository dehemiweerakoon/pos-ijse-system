package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.FileData;
import lk.ijse.pos.Repository.FIleDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class FileDataServiceImpl implements FileDataService{

    //
    @Autowired
    private FIleDataRepository fileDataRepository;

    final String currentPath = System.getProperty("user.dir");
    @Override
    public String uploadImageFileData(MultipartFile file) throws IOException {
        String currentPath = System.getProperty("user.dir");

        // Print the current path
        //System.out.println("Current working directory: " + currentPath);
        String file_path= currentPath+"/src/main/resources/static/"+file.getOriginalFilename();
        FileData fileData =fileDataRepository.save(FileData.builder().
                name(file.getOriginalFilename()).type(file.getContentType())
                .filePath(Path.of(file_path).toString()).build());
        file.transferTo(new File(file_path));
        return "file uploaded successfully :" + file.getOriginalFilename();
        //return "";
    }

    @Override
    public byte[] getFileData(String filename) throws IOException {
        Optional<FileData> dbImageData = fileDataRepository.findByName(filename);
        //System.out.println(dbImageData.get().getFilePath());
        String filepath = dbImageData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filepath).toPath());
        // images added to the image file in the description...///
        return images;
    }

}
