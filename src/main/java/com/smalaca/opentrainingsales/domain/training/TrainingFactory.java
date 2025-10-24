package com.smalaca.opentrainingsales.domain.training;

// factory
public class TrainingFactory {
    public Training create(AddNewTrainingDomainCommand command) {
        return new Training(command);
    }
}
