package com.smalaca.opentrainingsales.domain.trainingregistration;

import com.smalaca.opentrainingsales.domain.basket.Basket;
import com.smalaca.opentrainingsales.domain.training.ParticipantId;
import com.smalaca.opentrainingsales.domain.training.Training;

// domain service
public class TrainingRegistrationDomainService {
    public void registerFor(Basket basket, Training training, ParticipantId participantId) {
        basket.remove(training.getTrainingId());
        training.register(participantId);
    }
}
