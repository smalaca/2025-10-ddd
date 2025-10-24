package com.smalaca.trainingdefinition.domain.trainingdraft;

import com.smalaca.trainingdefinition.domain.trainingproposition.Category;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainerId;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainingPropositionId;

// aggregate root
public class TrainingDraft {
    private final TrainingPropositionId trainingPropositionId;
    private final String name;
    private final String description;
    private final Category category;
    private final TrainerId trainerId;
    private TrainingDraftId trainingDraftId;
    private Price price;
    private int trainingDays;

    private TrainingDraft(TrainingPropositionId trainingPropositionId, String name, String description, Category category, TrainerId trainerId) {
        this.trainingPropositionId = trainingPropositionId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.trainerId = trainerId;
    }

    // factory
    public static TrainingDraft create(TrainingPropositionId trainingPropositionId, String name, String description, Category category, TrainerId trainerId) {
        // generate TrainingDraftCode
        return new TrainingDraft(trainingPropositionId, name, description, category, trainerId);
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
