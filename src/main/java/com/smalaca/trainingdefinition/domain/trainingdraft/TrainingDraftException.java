package com.smalaca.trainingdefinition.domain.trainingdraft;

class TrainingDraftException extends RuntimeException {
    private TrainingDraftException(String message) {
        super(message);
    }

    static RuntimeException notEnoughDays(TrainingDraftId trainingDraftId, int trainingDays) {
        return new TrainingDraftException("Training days for TrainingDraft: " + trainingDraftId.trainingDraftId() + " must be greater than one. Was: " + trainingDays);
    }

    static RuntimeException tooManyDays(TrainingDraftId trainingDraftId, int trainingDays) {
        return new TrainingDraftException("Training days for TrainingDraft: " + trainingDraftId.trainingDraftId() + " cannot be longer than working week. Was: " + trainingDays);
    }
}
