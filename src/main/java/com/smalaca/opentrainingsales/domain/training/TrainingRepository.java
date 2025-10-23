package com.smalaca.opentrainingsales.domain.training;

import java.util.UUID;

// repository
public interface TrainingRepository {
    UUID save(Training training);
}
