package com.smalaca.trainingdefinition.application.training;

import com.smalaca.trainingdefinition.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingdefinition.domain.training.Training;
import com.smalaca.trainingdefinition.domain.training.TrainingDomainService;
import com.smalaca.trainingdefinition.domain.training.TrainingId;
import com.smalaca.trainingdefinition.domain.training.TrainingRepository;
import com.smalaca.trainingdefinition.domain.training.events.GuardiansSwitchedDomainEvent;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final TrainingDomainService trainingDomainService;
    private final EventPublisher eventPublisher;

    TrainingApplicationService(
            TrainingRepository trainingRepository, TrainingDomainService trainingDomainService, EventPublisher eventPublisher) {
        this.trainingRepository = trainingRepository;
        this.trainingDomainService = trainingDomainService;
        this.eventPublisher = eventPublisher;
    }

    public void switchGuardians(UUID trainingIdOne, UUID trainingIdTwo) {
        Training trainingOne = trainingRepository.findById(new TrainingId(trainingIdOne));
        Training trainingTwo = trainingRepository.findById(new TrainingId(trainingIdTwo));

        GuardiansSwitchedDomainEvent event = trainingDomainService.switchGuardians(trainingOne, trainingTwo);

        trainingRepository.save(trainingOne);
        trainingRepository.save(trainingTwo);
        eventPublisher.publish(event);
    }
}
