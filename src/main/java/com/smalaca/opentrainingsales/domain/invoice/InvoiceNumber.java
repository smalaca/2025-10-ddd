package com.smalaca.opentrainingsales.domain.invoice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// value object
public class InvoiceNumber {
    private final String number;

    private InvoiceNumber(String number) {
        this.number = number;
    }

    static InvoiceNumber create() {
        return new InvoiceNumber("FAK/" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
