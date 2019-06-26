package org.shop.config.beanprocessor;

import org.shop.annotation.CustomBean;
import org.shop.annotation.InjectRandomIntAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor customBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean(initMethod = "init")
    public CustomBean customBean() {
        return new CustomBean();
    }
}
