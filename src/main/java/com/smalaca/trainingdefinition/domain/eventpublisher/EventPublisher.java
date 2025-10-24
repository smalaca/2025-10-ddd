package com.smalaca.trainingdefinition.domain.eventpublisher;

import com.smalaca.trainingdefinition.domain.training.events.GuardiansSwitchedDomainEvent;

public interface EventPublisher {
    void publish(GuardiansSwitchedDomainEvent event);
}
