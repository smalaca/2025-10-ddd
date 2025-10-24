package com.smalaca.opentrainingsales.domain.order.events;

public record TrainingPaidResult(com.smalaca.opentrainingsales.domain.invoice.Invoice invoice,
                                 TrainingPaidDomainEvent trainingPaidDomainEvent) {
}
