package com.smalaca.trainingdefinition.domain.trainingidea;

// Aggregate Root - Entity
public class TrainingIdea {
    private final TrainingIdeaNumber trainingIdeaNumber;

    private TrainingIdea(TrainingIdeaNumber trainingIdeaNumber) {
        this.trainingIdeaNumber = trainingIdeaNumber;
    }

    // Factory
    public static TrainingIdea create(TrainerId trainerId) {
        TrainingIdeaNumber trainingIdeaNumber = TrainingIdeaNumber.from(trainerId);
        return new TrainingIdea(trainingIdeaNumber);
    }
}
