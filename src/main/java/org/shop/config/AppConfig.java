package org.shop.config;

import org.shop.config.aspect.AspectConfig;
import org.shop.config.beanprocessor.BeanPostProcessorConfig;
import org.shop.config.factory.FactoryConfig;
import org.shop.config.initializer.InitializerConfig;
import org.shop.config.repository.RepositoryConfig;
import org.shop.config.service.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({RepositoryConfig.class, ServiceConfig.class, FactoryConfig.class, InitializerConfig.class, AspectConfig.class,
        BeanPostProcessorConfig.class})
public class AppConfig {
}
