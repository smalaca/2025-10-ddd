package com.smalaca.opentrainingsales.domain.training;

// aggregate root
public class Training {
    private TrainingId trainingId;
    private final TrainerId trainerId;
    private final TrainingDefinitionId trainingDefinitionId;
    private final TrainingCode trainingCode;
    private final Price price;
    private final Period period;

    public Training(AddNewTrainingDomainCommand command) {
        trainerId = command.trainerId();
        trainingDefinitionId = command.trainingDefinitionId();
        trainingCode = command.trainingCode();
        period = command.period();
        price = command.price();
    }
}
