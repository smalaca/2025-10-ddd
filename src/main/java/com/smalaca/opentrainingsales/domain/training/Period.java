package com.smalaca.opentrainingsales.domain.training;

import java.time.LocalDate;

// value object
public record Period(LocalDate startDate, LocalDate endDate) {

}
