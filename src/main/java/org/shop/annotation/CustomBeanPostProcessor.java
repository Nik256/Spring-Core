package org.shop.annotation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LogManager.getLogger(CustomBeanPostProcessor.class.getName());
    private static final Random random = new Random();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(InjectRandomInt.class) != null) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                try {
                    field.setAccessible(true);
                    field.setInt(bean, getRandomNumberInRange(annotation.minValue(), annotation.maxValue()));
                    logger.info("Called postProcessAfterInitialization() for : " + beanName);
                } catch (IllegalAccessException e) {
                    logger.error(e);
                }
            }
        }
        return bean;
    }

    private static int getRandomNumberInRange(int min, int max) {
        return random.ints(min, (max + 1))
                .findFirst()
                .getAsInt();
    }
}
