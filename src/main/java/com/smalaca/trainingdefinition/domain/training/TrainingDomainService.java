package com.smalaca.trainingdefinition.domain.training;

import com.smalaca.trainingdefinition.domain.training.events.GuardiansSwitchedDomainEvent;

// domain service
public class TrainingDomainService {
    public GuardiansSwitchedDomainEvent switchGuardians(Training trainingOne, Training trainingTwo) {
        GuardianId guardianIdOne = trainingOne.getGaurdianId();
        GuardianId guardianIdTwo = trainingTwo.getGaurdianId();
        trainingOne.changeTo(guardianIdTwo);
        trainingTwo.changeTo(guardianIdOne);

//        return asList(trainingOne, trainingTwo);
//        return Result(event, trainingOne, trainingTwo);
        return new GuardiansSwitchedDomainEvent(
                trainingOne.getTrainingId().trainingId(), guardianIdOne.guardianId(), guardianIdTwo.guardianId(),
                trainingTwo.getTrainingId().trainingId(), guardianIdTwo.guardianId(), guardianIdOne.guardianId());
    }
}
