package com.smalaca.opentrainingsales.domain.trainingoffer;

import com.smalaca.opentrainingsales.domain.training.Price;
import com.smalaca.opentrainingsales.domain.trainingid.TrainingId;

// aggregate root
public class TrainingOffer {
    private final TrainingOfferNumber trainingOfferNumber;
    private final TrainingId trainingId;
    private final Price price;

    private TrainingOffer(TrainingOfferNumber trainingOfferNumber, TrainingId trainingId, Price price) {
        this.trainingOfferNumber = trainingOfferNumber;
        this.trainingId = trainingId;
        this.price = price;
    }

    // factory
    public static TrainingOffer create(TrainingId trainingId, Price price) {
        TrainingOfferNumber trainingOfferNumber = TrainingOfferNumber.create();

        return new TrainingOffer(trainingOfferNumber, trainingId, price);
    }
}
