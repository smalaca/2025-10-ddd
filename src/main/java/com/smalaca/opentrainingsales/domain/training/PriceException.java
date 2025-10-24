package com.smalaca.opentrainingsales.domain.training;

import java.math.BigDecimal;

class PriceException extends RuntimeException {
    PriceException(BigDecimal price) {
        super("Price must be greater than zero. Price was " + price);
    }
}
