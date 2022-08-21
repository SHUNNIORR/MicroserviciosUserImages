package pragma.ms_image.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "fileImagen")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserImageEntity {
    @Id
    private String id;
    @Field
    private String base64;
    @Field
    private Integer numberClientDocument;
}
