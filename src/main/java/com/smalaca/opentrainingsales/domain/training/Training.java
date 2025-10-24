package com.smalaca.opentrainingsales.domain.training;

import com.smalaca.opentrainingsales.domain.trainingid.TrainingId;

// aggregate root
public class Training {
    private final int minimalAttendees;
    private final int maximalAttendees;
    private TrainingId trainingId;
    private final TrainerId trainerId;
    private final TrainingDefinitionId trainingDefinitionId;
    private final TrainingCode trainingCode;
    private final Price price;
    private final Period period;

    Training(AddNewTrainingDomainCommand command) {
        trainerId = command.trainerId();
        trainingDefinitionId = command.trainingDefinitionId();
        trainingCode = command.trainingCode();
        period = command.period();
        price = command.price();
        minimalAttendees = command.minimalAttendees();
        maximalAttendees = command.maximalAttendees();
    }
}
