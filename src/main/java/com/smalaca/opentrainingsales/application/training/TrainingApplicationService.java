package com.smalaca.opentrainingsales.application.training;

import com.smalaca.opentrainingsales.domain.training.AddNewTrainingDomainCommand;
import com.smalaca.opentrainingsales.domain.training.Period;
import com.smalaca.opentrainingsales.domain.training.Price;
import com.smalaca.opentrainingsales.domain.training.TrainerId;
import com.smalaca.opentrainingsales.domain.training.Training;
import com.smalaca.opentrainingsales.domain.training.TrainingCode;
import com.smalaca.opentrainingsales.domain.training.TrainingDefinitionId;
import com.smalaca.opentrainingsales.domain.training.TrainingRepository;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public UUID addTraining(AddNewTrainingCommand command) {
        TrainingDefinitionId trainingDefinitionId = new TrainingDefinitionId(command.trainingDefinitionId());
        TrainerId trainerId = new TrainerId(command.trainerId());
        TrainingCode trainingCode = new TrainingCode(command.trainingCode());
        Period period = new Period(command.startDate(), command.endDate());
        Price price = Price.from(command.price());
        AddNewTrainingDomainCommand domainCommand = new AddNewTrainingDomainCommand(
                trainerId, trainingDefinitionId, trainingCode, period, price);

        Training training = new Training(domainCommand);

        return trainingRepository.save(training);
    }
}
