package com.smalaca.trainingdefinition.domain.trainingdraft;

// repository
public interface TrainingDraftRepository {
    TrainingDraft findById(TrainingDraftId trainingDraftId);

    void save(TrainingDraft trainingDraft);
}
