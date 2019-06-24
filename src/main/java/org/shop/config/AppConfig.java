package org.shop.config;

import org.shop.config.factory.FactoryConfig;
import org.shop.config.initializer.InitializerConfig;
import org.shop.config.repository.RepositoryConfig;
import org.shop.config.service.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class, ServiceConfig.class, FactoryConfig.class, InitializerConfig.class})
public class AppConfig {

}
