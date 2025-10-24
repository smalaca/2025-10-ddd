package com.smalaca.trainingdefinition.domain.training;

// repository
public interface TrainingRepository {
    Training findById(TrainingId trainingId);

    void save(Training training);
}
