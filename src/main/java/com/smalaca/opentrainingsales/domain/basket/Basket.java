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
}
