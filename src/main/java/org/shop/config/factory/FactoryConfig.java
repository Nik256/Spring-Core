package org.shop.config.factory;

import org.shop.repository.factory.UserRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

    @Bean
    UserRepositoryFactory userRepositoryFactory() {
        return new UserRepositoryFactory();
    }
}
