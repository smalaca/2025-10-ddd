package com.smalaca.opentrainingsales.domain.training;

import com.smalaca.opentrainingsales.domain.trainingsdefinitions.TrainingsDefinitions;

// factory
public class TrainingFactory {
    private final TrainingsDefinitions trainingsDefinitions;

    TrainingFactory(TrainingsDefinitions trainingsDefinitions) {
        this.trainingsDefinitions = trainingsDefinitions;
    }

    public Training create(AddNewTrainingDomainCommand command) {
        if (command.minimalAttendees() < 5) {
            throw new IllegalArgumentException("Minimal attendees must be at least 5");
        }

        if (command.maximalAttendees() > 20) {
            throw new IllegalArgumentException("Maximal attendees must be at most 20");
        }

        if (command.maximalAttendees() < command.minimalAttendees()) {
            throw new IllegalArgumentException("Maximal attendees must be greater than minimal attendees");
        }

        if (trainingsDefinitions.doesNotExist(command.trainingDefinitionId())) {
            throw new IllegalArgumentException("TrainingDefinitionId: " + command.trainingDefinitionId() + " does not exist");
        }

        return new Training(command);
    }
}
