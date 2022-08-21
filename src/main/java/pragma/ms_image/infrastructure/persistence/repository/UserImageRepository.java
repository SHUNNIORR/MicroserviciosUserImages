package pragma.ms_image.infrastructure.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pragma.ms_image.infrastructure.persistence.entities.UserImageEntity;

@Repository
public interface UserImageRepository extends MongoRepository<UserImageEntity, Integer> {
    UserImageEntity findByNumberClientDocument(Integer numberClientDocument);

    boolean existsByNumberClientDocument(Integer numberClientDocument);
}
