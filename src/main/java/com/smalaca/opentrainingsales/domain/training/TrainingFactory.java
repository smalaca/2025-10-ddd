package com.smalaca.opentrainingsales.domain.training;

// factory
public class TrainingFactory {
    public Training create(TrainingCode trainingCode, Period period) {
        return new Training(trainingCode, period);
    }
}
