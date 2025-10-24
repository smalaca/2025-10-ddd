package com.smalaca.opentrainingsales.domain.trainingregistration;

import com.smalaca.opentrainingsales.domain.basket.Basket;
import com.smalaca.opentrainingsales.domain.training.ParticipantId;
import com.smalaca.opentrainingsales.domain.training.Training;
import com.smalaca.opentrainingsales.domain.trainingoffer.TrainingOffer;

// domain service
public class TrainingRegistrationDomainService {
    public TrainingOffer registerFor(Basket basket, Training training, ParticipantId participantId) {
        basket.remove(training.getTrainingId());
        TrainingOffer trainingOffer = training.register(participantId);

        return trainingOffer;
    }
}
