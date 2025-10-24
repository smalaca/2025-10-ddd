package com.smalaca.trainingdefinition.domain.trainingdraft;

// aggregate root
public class TrainingDraft {
    private TrainingDraftId trainingDraftId;
    private Price price;
    private int trainingDays;

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
