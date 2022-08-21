package pragma.ms_image.domain.useCases.services;

import org.springframework.web.multipart.MultipartFile;
import pragma.ms_image.domain.model.FileImagenDto;

import java.util.List;

public interface UserImageServices {
    List<FileImagenDto> findAll();

    boolean save(Integer identificacion, MultipartFile file) throws Exception;

    boolean delete(Integer identificacion);

    boolean update(Integer identificacion, MultipartFile file) throws Exception;

    FileImagenDto findByIdentificacion(Integer numero);

    FileImagenDto findById(Integer id);

    boolean existsByIdentificacion(Integer numero);
}
