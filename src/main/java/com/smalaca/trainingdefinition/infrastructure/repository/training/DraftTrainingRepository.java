package com.smalaca.trainingdefinition.infrastructure.repository.training;

import com.smalaca.trainingdefinition.domain.training.Training;
import com.smalaca.trainingdefinition.domain.training.TrainingId;
import com.smalaca.trainingdefinition.domain.training.TrainingRepository;

public class DraftTrainingRepository implements TrainingRepository {
    @Override
    public Training findById(TrainingId trainingId) {
        return null;
    }

    @Override
    public void save(Training training) {
        // orm
        // czyste zapytania
        // event sourcing
    }
}
