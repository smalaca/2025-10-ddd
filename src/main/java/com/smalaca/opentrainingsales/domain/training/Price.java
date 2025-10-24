package com.smalaca.opentrainingsales.domain.training;

import java.math.BigDecimal;

// value object
public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    public static Price from(BigDecimal price) {
        if (BigDecimal.ZERO.compareTo(price) >= 0) {
            throw new PriceException(price);
        }

        return new Price(price);
    }
}
