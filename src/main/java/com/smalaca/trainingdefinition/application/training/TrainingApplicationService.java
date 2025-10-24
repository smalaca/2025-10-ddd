package com.smalaca.trainingdefinition.application.training;

import com.smalaca.trainingdefinition.domain.training.Training;
import com.smalaca.trainingdefinition.domain.training.TrainingDomainService;
import com.smalaca.trainingdefinition.domain.training.TrainingId;
import com.smalaca.trainingdefinition.domain.training.TrainingRepository;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final TrainingDomainService trainingDomainService;

    TrainingApplicationService(TrainingRepository trainingRepository, TrainingDomainService trainingDomainService) {
        this.trainingRepository = trainingRepository;
        this.trainingDomainService = trainingDomainService;
    }

    public void switchGuardians(UUID trainingIdOne, UUID trainingIdTwo) {
        Training trainingOne = trainingRepository.findById(new TrainingId(trainingIdOne));
        Training trainingTwo = trainingRepository.findById(new TrainingId(trainingIdTwo));

        trainingDomainService.switchGuardians(trainingOne, trainingTwo);

        trainingRepository.save(trainingOne);
        trainingRepository.save(trainingTwo);
    }
}
