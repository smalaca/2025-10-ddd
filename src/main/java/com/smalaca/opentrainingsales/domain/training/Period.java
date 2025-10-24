package com.smalaca.opentrainingsales.domain.training;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// value object
public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    private Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Period between(LocalDate startDate, LocalDate endDate) {
        if (!startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Start Date must be in future");
        }

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End Date must be after Start Date");
        }

        if (ChronoUnit.DAYS.between(startDate, endDate) > 5) {
            throw new IllegalArgumentException("Training Period cannot be longer than working week");
        }

        return new Period(startDate, endDate);
    }
}
