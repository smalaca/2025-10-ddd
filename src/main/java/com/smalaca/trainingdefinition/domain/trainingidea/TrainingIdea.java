package com.smalaca.trainingdefinition.domain.trainingidea;

// Aggregate Root - Entity
public class TrainingIdea {
    private TrainingIdeaId trainingIdeaId;
    private final String name;
    private final String description;
    private final Category category;
    private final TrainerId trainerId;
    private final TrainingIdeaNumber trainingIdeaNumber;

    private TrainingIdea(String name, String description, Category category, TrainerId trainerId, TrainingIdeaNumber trainingIdeaNumber) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.trainerId = trainerId;
        this.trainingIdeaNumber = trainingIdeaNumber;
    }

    // Factory
    public static TrainingIdea create(String name, String description, Category category, TrainerId trainerId) {
        TrainingIdeaNumber trainingIdeaNumber = TrainingIdeaNumber.from(trainerId);

        return new TrainingIdea(name, description, category, trainerId, trainingIdeaNumber);
    }
}
