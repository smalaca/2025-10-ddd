package com.smalaca.opentrainingsales.domain.basket;

import com.smalaca.opentrainingsales.domain.trainingid.TrainingId;

import java.util.ArrayList;
import java.util.List;

// aggregate root
public class Basket {
    private BasketId basketId;
    private CustomerId customerId;
    private final List<TrainingId> trainingIds = new ArrayList<>();

    public void add(TrainingId trainingId) {
        trainingIds.add(trainingId);
    }

    public void remove(TrainingId trainingId) {
        if (!trainingIds.contains(trainingId)) {
            throw new IllegalArgumentException("TrainingId: " + trainingId.trainingId() + " not found in basket: " + basketId.basketId());
        }

        trainingIds.remove(trainingId);
    }
}
