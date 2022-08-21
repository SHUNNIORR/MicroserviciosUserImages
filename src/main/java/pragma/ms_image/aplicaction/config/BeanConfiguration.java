package pragma.ms_image.aplicaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pragma.ms_image.domain.useCases.UserImageUseCase;
import pragma.ms_image.domain.useCases.services.UserImageServices;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserImageUseCase userImageUseCase(UserImageServices userImageServices){return new UserImageUseCase(userImageServices);}
}
