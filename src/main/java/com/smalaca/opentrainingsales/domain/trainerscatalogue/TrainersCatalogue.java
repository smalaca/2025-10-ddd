package com.smalaca.opentrainingsales.domain.trainerscatalogue;

import com.smalaca.opentrainingsales.domain.training.TrainerId;
import com.smalaca.opentrainingsales.domain.training.TrainingDefinitionId;

public interface TrainersCatalogue {
    boolean canConductTraining(TrainerId trainerId, TrainingDefinitionId trainingDefinitionId);
}
