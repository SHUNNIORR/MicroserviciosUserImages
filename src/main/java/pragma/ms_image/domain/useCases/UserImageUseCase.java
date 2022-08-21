package pragma.ms_image.domain.useCases;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import pragma.ms_image.domain.model.FileImagenDto;
import pragma.ms_image.domain.useCases.services.UserImageServices;

import java.util.List;

@RequiredArgsConstructor
public class UserImageUseCase {
    private final UserImageServices userImageServices;

    public FileImagenDto findByIdentificacion(Integer numero){
        return userImageServices.findByIdentificacion(numero);
    }

    public List<FileImagenDto> findAll(){
        return userImageServices.findAll();
    }

    public boolean save(Integer identificacion, MultipartFile file) throws Exception {
        return userImageServices.save(identificacion,file);
    }

    public boolean delete(Integer identificacion){
        return userImageServices.delete(identificacion);
    }

    public boolean update(Integer identificacion, MultipartFile file) throws Exception {
        return userImageServices.update(identificacion,file);
    }
}
