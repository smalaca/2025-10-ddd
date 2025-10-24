package com.smalaca.opentrainingsales.application.training;

import com.smalaca.opentrainingsales.domain.training.Period;
import com.smalaca.opentrainingsales.domain.training.Training;
import com.smalaca.opentrainingsales.domain.training.TrainingCode;
import com.smalaca.opentrainingsales.domain.training.TrainingFactory;
import com.smalaca.opentrainingsales.domain.training.TrainingRepository;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final TrainingFactory trainingFactory;

    public TrainingApplicationService(TrainingRepository trainingRepository, TrainingFactory trainingFactory) {
        this.trainingRepository = trainingRepository;
        this.trainingFactory = trainingFactory;
    }

    public UUID addTraining(AddNewTrainingCommand command) {
        TrainingCode trainingCodeVO = new TrainingCode(command.trainingCode());
        Period period = new Period(command.startDate(), command.endDate());

        Training training = trainingFactory.create(trainingCodeVO, period);

        return trainingRepository.save(training);
    }
}
