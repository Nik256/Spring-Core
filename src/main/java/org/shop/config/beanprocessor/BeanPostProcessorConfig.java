package org.shop.config.beanprocessor;

import org.shop.annotation.CustomBean;
import org.shop.annotation.CustomBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {

    @Bean
    public CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean
    public CustomBean customBean() {
        return new CustomBean();
    }
}
