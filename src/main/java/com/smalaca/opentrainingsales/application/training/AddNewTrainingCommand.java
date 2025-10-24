package com.smalaca.opentrainingsales.application.training;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AddNewTrainingCommand(
        UUID trainingDefinitionId, UUID trainerId, String trainingCode,
        BigDecimal price, LocalDate startDate, LocalDate endDate,
        int minimalAttendees, int maximalAttendees) {
}

