package com.smalaca.opentrainingsales.application.training;

import com.smalaca.opentrainingsales.domain.training.Period;
import com.smalaca.opentrainingsales.domain.training.Training;
import com.smalaca.opentrainingsales.domain.training.TrainingCode;
import com.smalaca.opentrainingsales.domain.training.TrainingRepository;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public UUID addTraining(AddNewTrainingCommand command) {
        TrainingCode trainingCodeVO = new TrainingCode(command.trainingCode());
        Period period = new Period(command.startDate(), command.endDate());

        Training training = new Training(trainingCodeVO, period);

        return trainingRepository.save(training);
    }
}
