package com.smalaca.trainingdefinition.domain.training;

// domain service
public class TrainingDomainService {
    public void switchGuardians(Training trainingOne, Training trainingTwo) {
        GuardianId guardianIdOne = trainingOne.getGaurdianId();
        GuardianId guardianIdTwo = trainingTwo.getGaurdianId();
        trainingOne.changeTo(guardianIdTwo);
        trainingTwo.changeTo(guardianIdOne);

//        return asList(trainingOne, trainingTwo);
//        return GuardiansSwitched(trainingOne, trainingTwo);
    }
}
