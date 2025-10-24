package com.smalaca.trainingdefinition.domain.trainingdraft;

// aggregate root
public class TrainingDraft {
    private Price price;
    private int trainingDays;

    public void update(Price price, int trainingDays) {
        if (trainingDays < 1) {
            throw new IllegalArgumentException("Training days must be greater than one.");
        }

        if (trainingDays > 5) {
            throw new IllegalArgumentException("Training cannot be longer than working week.");
        }

        this.price = price;
        this.trainingDays = trainingDays;
    }
}
