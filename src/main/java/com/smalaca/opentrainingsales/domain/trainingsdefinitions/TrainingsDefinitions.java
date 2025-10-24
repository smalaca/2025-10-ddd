package com.smalaca.opentrainingsales.domain.trainingsdefinitions;

import com.smalaca.opentrainingsales.domain.training.TrainingDefinitionId;

public interface TrainingsDefinitions {
    boolean doesNotExist(TrainingDefinitionId trainingDefinitionId);
}
