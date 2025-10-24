package com.smalaca.opentrainingsales.domain.invoice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

// value object
public class InvoiceNumber {
    private final String number;

    private InvoiceNumber(String number) {
        this.number = number;
    }

    // factory
    static InvoiceNumber create() {
        return new InvoiceNumber("FAK/" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + "/" + UUID.randomUUID());
    }
}
