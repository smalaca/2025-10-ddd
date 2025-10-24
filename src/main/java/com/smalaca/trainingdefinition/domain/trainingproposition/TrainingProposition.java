package com.smalaca.trainingdefinition.domain.trainingproposition;

import com.smalaca.trainingdefinition.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraft;

// Aggregate Root - Entity
public class TrainingProposition {
    private TrainingPropositionId trainingPropositionId;
    private final String name;
    private final String description;
    private final Category category;
    private final TrainerId trainerId;
    private final TrainingPropositionNumber trainingPropositionNumber;
    private ReviewStatus reviewStatus;

//    private TrainersCatalogue trainersCatalogue;

    private TrainingProposition(String name, String description, Category category, TrainerId trainerId, TrainingPropositionNumber trainingPropositionNumber) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.trainerId = trainerId;
        this.trainingPropositionNumber = trainingPropositionNumber;
    }

    // Factory
    public static TrainingProposition create(CreateTrainingPropositionDomainCommand command) {
        TrainingPropositionNumber trainingPropositionNumber = TrainingPropositionNumber.from(command.trainerId());

        return new TrainingProposition(command.name(), command.description(), command.category(), command.trainerId(), trainingPropositionNumber);
    }

    public TrainingDraft accept(TrainersCatalogue trainersCatalogue, ReviewerId reviewerId) {
//    public TrainingDraft accept(ReviewerId reviewerId) {
        // sprawdzenie kompetencji recenzenta
        if (trainersCatalogue.canValidate(reviewerId, category)) {
            // aktualizacja statusu propozycji
            reviewStatus = ReviewStatus.ACCEPTED;

            // stworzenie draftu
            return TrainingDraft.create(trainingPropositionId, name, description, category, trainerId);
        }

        throw new IllegalArgumentException("Cannot accept Training Proposition with id: " + trainingPropositionId.trainingPropositionId() + " by Reviewer with id: " + reviewerId.reviewerId());
    }
}
