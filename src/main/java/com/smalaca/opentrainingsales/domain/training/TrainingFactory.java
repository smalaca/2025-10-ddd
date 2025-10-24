package com.smalaca.opentrainingsales.domain.training;

// factory
public class TrainingFactory {
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

        return new Training(command);
    }
}
