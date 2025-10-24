package com.smalaca.trainingdefinition.domain.trainingdraft;

import com.smalaca.trainingdefinition.domain.trainingidea.Category;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainerId;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainingIdeaId;

// aggregate root
public class TrainingDraft {
    private final TrainingIdeaId trainingIdeaId;
    private final String name;
    private final String description;
    private final Category category;
    private final TrainerId trainerId;
    private TrainingDraftId trainingDraftId;
    private Price price;
    private int trainingDays;

    private TrainingDraft(TrainingIdeaId trainingIdeaId, String name, String description, Category category, TrainerId trainerId) {
        this.trainingIdeaId = trainingIdeaId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.trainerId = trainerId;
    }

    // factory
    public static TrainingDraft create(TrainingIdeaId trainingIdeaId, String name, String description, Category category, TrainerId trainerId) {
        // generate TrainingDraftCode
        return new TrainingDraft(trainingIdeaId, name, description, category, trainerId);
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
