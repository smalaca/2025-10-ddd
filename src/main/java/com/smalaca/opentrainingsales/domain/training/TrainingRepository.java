package com.smalaca.opentrainingsales.domain.training;

import com.smalaca.opentrainingsales.domain.trainingid.TrainingId;

import java.util.UUID;

// repository
public interface TrainingRepository {
    UUID save(Training training);

    Training findBy(TrainingId trainingId);
}
