package com.smalaca.trainingdefinition.domain.trainingproposition;

import java.util.UUID;

// value object
class TrainingPropositionNumber {
    private final String value;

    private TrainingPropositionNumber(String value) {
        this.value = value;
    }

    // factory
    static TrainingPropositionNumber from(TrainerId trainerId) {
        return new TrainingPropositionNumber(trainerId.trainerId() + "/" + UUID.randomUUID());
    }
}
