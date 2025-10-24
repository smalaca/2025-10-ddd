package com.smalaca.trainingdefinition.domain.trainingidea;

import java.util.UUID;

// value object
class TrainingIdeaNumber {
    private final String value;

    private TrainingIdeaNumber(String value) {
        this.value = value;
    }

    // factory
    static TrainingIdeaNumber from(TrainerId trainerId) {
        return new TrainingIdeaNumber(trainerId.trainerId() + "/" + UUID.randomUUID());
    }
}
