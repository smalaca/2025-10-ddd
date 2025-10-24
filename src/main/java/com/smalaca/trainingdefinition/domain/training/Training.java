package com.smalaca.trainingdefinition.domain.training;

// aggregate root
public class Training {
    private TrainingId trainingId;
    private GuardianId guardianId;

    GuardianId getGaurdianId() {
        return guardianId;
    }

    void changeTo(GuardianId guardianId) {
        this.guardianId = guardianId;
    }

    TrainingId getTrainingId() {
        return trainingId;
    }
}
