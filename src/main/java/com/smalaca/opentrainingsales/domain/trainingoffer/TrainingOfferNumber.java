package com.smalaca.opentrainingsales.domain.trainingoffer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

// value object
class TrainingOfferNumber {
    private final String number;

    private TrainingOfferNumber(String number) {
        this.number = number;
    }

    // factory
    static TrainingOfferNumber create() {
        return new TrainingOfferNumber("OS/" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + "/" + UUID.randomUUID());
    }
}
