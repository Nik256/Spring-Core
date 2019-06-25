package org.shop.annotation;

import org.springframework.stereotype.Component;

@Component
public class CustomBean {

    @InjectRandomInt(minValue = 1, maxValue = 100)
    private int number;

    @Override
    public String toString() {
        return "CustomBean{" +
                "number=" + number +
                '}';
    }
}
