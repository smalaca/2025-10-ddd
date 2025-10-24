package com.smalaca.opentrainingsales.domain.order;

import com.smalaca.opentrainingsales.domain.invoice.Invoice;
import com.smalaca.opentrainingsales.domain.order.events.TrainingPaidDomainEvent;
import com.smalaca.opentrainingsales.domain.order.events.TrainingPaidResult;

// aggregate root
public class Order {
    private OrderId orderId;

    public TrainingPaidResult pay() {
        // payment should happen here

        Invoice invoice = Invoice.create(orderId);
        TrainingPaidDomainEvent trainingPaidDomainEvent = new TrainingPaidDomainEvent(orderId, invoice.getInvoiceNumber());

        return new TrainingPaidResult(invoice, trainingPaidDomainEvent);
    }
}
