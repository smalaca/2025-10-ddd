package com.smalaca.trainingdefinition.domain.trainingdraft;

import com.smalaca.trainingdefinition.domain.trainingproposition.Category;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainerId;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainingPropositionId;

// aggregate root
public class TrainingDraft {
    private TrainingDraftId trainingDraftId;
    private final TrainingPropositionId trainingPropositionId;
    private final TrainerId trainerId;
    private final TrainingDraftNumber trainingDraftNumber;
    private final String name;
    private final String description;
    private final Category category;
    private Price price;
    private int trainingDays;

    private TrainingDraft(
            TrainingPropositionId trainingPropositionId, TrainerId trainerId, TrainingDraftNumber trainingDraftNumber,
            String name, String description, Category category) {
        this.trainingPropositionId = trainingPropositionId;
        this.trainerId = trainerId;
        this.trainingDraftNumber = trainingDraftNumber;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // factory
    public static TrainingDraft create(TrainingPropositionId trainingPropositionId, String name, String description, Category category, TrainerId trainerId) {
        TrainingDraftNumber trainingDraftNumber = TrainingDraftNumber.from(trainerId);
        return new TrainingDraft(trainingPropositionId, trainerId, trainingDraftNumber, name, description, category);
    }

    public void update(Price price, int trainingDays) {
        if (trainingDays < 1) {
            throw TrainingDraftException.notEnoughDays(trainingDraftId, trainingDays);
        }

        if (trainingDays > 5) {
            throw TrainingDraftException.tooManyDays(trainingDraftId, trainingDays);
        }

        this.price = price;
        this.trainingDays = trainingDays;
    }
}
