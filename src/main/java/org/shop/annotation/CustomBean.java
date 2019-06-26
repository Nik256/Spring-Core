package org.shop.annotation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;

public class CustomBean {
    private static final Logger logger = LogManager.getLogger(CustomBean.class.getName());

    @InjectRandomInt(minValue = 1, maxValue = 100)
    private int number;

    public CustomBean() {
        logger.info("Called constructor");
    }

    public void init() {
        number = 111111111;
        logger.info("Called init method");
    }

    @PostConstruct
    public void postConstruct() {
        number = 222222222;
        logger.info("Called PostConstruct method");
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "number=" + number +
                '}';
    }
}
