package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Image;
import lk.ijse.pos.Repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String saveImage(MultipartFile file) throws Exception {
        var imageToSave = Image.builder().name(
                file.getOriginalFilename()
        ).type(file.getContentType()).imageDate(file.getBytes()).build();
        imageRepository.save(imageToSave);
        return "file uploaded successfully"+file.getOriginalFilename();
    }

    @Override
    public byte[] uploadImage(String filename) throws Exception {
        Optional<Image> dbImage = imageRepository.findByName(filename);
        if(dbImage.isPresent()) {
            return dbImage.get().getImageDate();
        }else{
            throw new Exception("Image not found");
        }
    }
}
