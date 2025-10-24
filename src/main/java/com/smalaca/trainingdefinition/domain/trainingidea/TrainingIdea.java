package com.smalaca.trainingdefinition.domain.trainingidea;

import com.smalaca.trainingdefinition.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraft;

// Aggregate Root - Entity
public class TrainingIdea {
    private TrainingIdeaId trainingIdeaId;
    private final String name;
    private final String description;
    private final Category category;
    private final TrainerId trainerId;
    private final TrainingIdeaNumber trainingIdeaNumber;
    private ReviewStatus reviewStatus;

//    private TrainersCatalogue trainersCatalogue;

    private TrainingIdea(String name, String description, Category category, TrainerId trainerId, TrainingIdeaNumber trainingIdeaNumber) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.trainerId = trainerId;
        this.trainingIdeaNumber = trainingIdeaNumber;
    }

    // Factory
    public static TrainingIdea create(CreateTrainingIdeaDomainCommand command) {
        TrainingIdeaNumber trainingIdeaNumber = TrainingIdeaNumber.from(command.trainerId());

        return new TrainingIdea(command.name(), command.description(), command.category(), command.trainerId(), trainingIdeaNumber);
    }

    public TrainingDraft accept(TrainersCatalogue trainersCatalogue, ReviewerId reviewerId) {
//    public TrainingDraft accept(ReviewerId reviewerId) {
        // sprawdzenie kompetencji recenzenta
        if (trainersCatalogue.canValidate(reviewerId, category)) {
            // aktualizacja statusu propozycji
            reviewStatus = ReviewStatus.ACCEPTED;

            // stworzenie draftu
            return TrainingDraft.create(trainingIdeaId, name, description, category, trainerId);
        }

        throw new IllegalArgumentException("Cannot accept TrainingIdea with id: " + trainingIdeaId.trainingIdeaId() + " by Reviewer with id: " + reviewerId.reviewerId());
    }
}
