package org.shop.annotation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LogManager.getLogger(InjectRandomIntAnnotationBeanPostProcessor.class.getName());
    private static final Random random = new Random();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.getAnnotation(InjectRandomInt.class) != null) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, getRandomNumberInRange(annotation.minValue(), annotation.maxValue()));
                logger.info("Called postProcessAfterInitialization() for : " + beanName);
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
