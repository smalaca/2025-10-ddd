package com.smalaca.opentrainingsales.application.training;

import java.time.LocalDate;

public record AddNewTrainingCommand(String trainingCode, LocalDate startDate, LocalDate endDate) {
}

