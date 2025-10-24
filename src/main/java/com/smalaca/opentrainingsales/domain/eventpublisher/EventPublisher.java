package com.smalaca.opentrainingsales.domain.eventpublisher;

import com.smalaca.opentrainingsales.domain.order.events.TrainingPaidDomainEvent;

public interface EventPublisher {
    void publish(TrainingPaidDomainEvent trainingPaidDomainEvent);
}
