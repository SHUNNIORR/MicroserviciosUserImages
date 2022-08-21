package pragma.ms_image.infrastructure.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pragma.ms_image.domain.model.FileImagenDto;
import pragma.ms_image.domain.useCases.services.UserImageServices;
import pragma.ms_image.infrastructure.handlerExceptions.exceptions.NotFilesInBdException;
import pragma.ms_image.infrastructure.handlerExceptions.exceptions.NotFoundFileException;
import pragma.ms_image.infrastructure.persistence.entities.UserImageEntity;
import pragma.ms_image.infrastructure.persistence.repository.UserImageRepository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserImageService implements UserImageServices {
    @Autowired
    private UserImageRepository userImageRepository;


    @Override
    public List<FileImagenDto> findAll() {
        if (userImageRepository.findAll().isEmpty()){
            throw new NotFilesInBdException();
        }
        List<UserImageEntity> userImageEntityList = userImageRepository.findAll();
        List<FileImagenDto> fileImagenDtoList = new ArrayList<>();
        for (UserImageEntity userImageEntity:
             userImageEntityList) {
            FileImagenDto fileImagenDto = FileImagenDto.builder()
                    .numberClientDocument(userImageEntity.getNumberClientDocument())
                    .base64(userImageEntity.getBase64())
                    .build();
            fileImagenDtoList.add(fileImagenDto);
        }
        return fileImagenDtoList;
    }

    @Override
    public boolean save(Integer identificacion, MultipartFile file) throws Exception {
        if(userImageRepository.existsByNumberClientDocument(identificacion)){
            throw new NotFilesInBdException();
        }
        byte[] bytes = file.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(bytes);

        UserImageEntity userImageEntity = UserImageEntity.builder().base64(encodedString).numberClientDocument(identificacion).build();
        userImageRepository.save(userImageEntity);
        return true;
    }

    @Override
    public boolean delete(Integer identificacion) {
        UserImageEntity userImageEntity = userImageRepository.findByNumberClientDocument(identificacion);
        userImageRepository.delete(userImageEntity);
        return true;
    }

    @Override
    public boolean update(Integer identificacion, MultipartFile file) throws Exception {
        return false;
    }

    @Override
    public FileImagenDto findByIdentificacion(Integer numero) {
        existsByIdentificacion(numero);
        UserImageEntity userImageEntity = userImageRepository.findByNumberClientDocument(numero);
        FileImagenDto fileImagenDto = FileImagenDto.builder().base64(userImageEntity.getBase64())
                .numberClientDocument(userImageEntity.getNumberClientDocument()).build();
        return fileImagenDto;
    }

    @Override
    public FileImagenDto findById(Integer id) {
        UserImageEntity userImageEntity = userImageRepository.findById(id).get();
        FileImagenDto fileImagenDto = FileImagenDto.builder().base64(userImageEntity.getBase64())
                .numberClientDocument(userImageEntity.getNumberClientDocument()).build();
        return fileImagenDto;
    }

    @Override
    public boolean existsByIdentificacion(Integer numero) {
        if(!userImageRepository.existsByNumberClientDocument(numero)){
           throw new NotFoundFileException();
        }
        return true;
    }
}
