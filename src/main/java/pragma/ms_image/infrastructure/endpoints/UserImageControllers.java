package pragma.ms_image.infrastructure.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pragma.ms_image.domain.model.FileDto;
import pragma.ms_image.domain.model.FileImagenDto;
import pragma.ms_image.domain.useCases.UserImageUseCase;

import java.util.List;

@RestController
public class UserImageControllers {
    @Autowired
    private UserImageUseCase userImageUseCase;

    @GetMapping("images")
    public List<FileImagenDto> getAllImages(){
        return userImageUseCase.findAll();
    }
    @GetMapping("images/{id}")
    public FileImagenDto getImageById(@PathVariable Integer id){
        return  userImageUseCase.findByIdentificacion(id);
    }
    @PostMapping("images/save")
    public boolean saveUserImage(@RequestParam("file") MultipartFile file,
                                 @RequestParam("id") Integer id)throws Exception{

        return userImageUseCase.save(id, file);
    }
}
