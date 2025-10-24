package com.smalaca.opentrainingsales.domain.training;

public record AddNewTrainingDomainCommand(
        TrainerId trainerId, TrainingDefinitionId trainingDefinitionId, TrainingCode trainingCode,
        Period period, Price price, int minimalAttendees, int maximalAttendees) {
}
