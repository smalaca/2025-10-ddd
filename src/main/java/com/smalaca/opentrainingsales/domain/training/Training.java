package com.smalaca.opentrainingsales.domain.training;

// aggregate root
public class Training {
    private final TrainingCode trainingCode;
    private final Period period;

    public Training(TrainingCode trainingCode, Period period) {
        this.trainingCode = trainingCode;
        this.period = period;
    }
}
