package com.smalaca.trainingdefinition.domain.trainingproposition;

import java.util.UUID;

// Repository
public interface TrainingPropositionRepository {
    UUID save(TrainingProposition trainingProposition);

    TrainingProposition findBy(TrainingPropositionId trainingPropositionId);
}
