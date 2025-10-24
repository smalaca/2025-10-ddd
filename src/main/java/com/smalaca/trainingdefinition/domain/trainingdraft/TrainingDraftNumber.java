package com.smalaca.trainingdefinition.domain.trainingdraft;

import com.smalaca.trainingdefinition.domain.trainingproposition.TrainerId;

import java.util.UUID;

// value object
class TrainingDraftNumber {
    private final String value;

    private TrainingDraftNumber(String value) {
        this.value = value;
    }

    // factory
    static TrainingDraftNumber from(TrainerId trainerId) {
        return new TrainingDraftNumber("DRAFT/" + trainerId.trainerId() + "/" + UUID.randomUUID());
    }
}
