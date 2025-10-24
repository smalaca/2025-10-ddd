package com.smalaca.opentrainingsales.domain.order.events;

import com.smalaca.opentrainingsales.domain.invoice.InvoiceNumber;
import com.smalaca.opentrainingsales.domain.order.OrderId;

public record TrainingPaidDomainEvent(OrderId orderId, InvoiceNumber invoiceNumber) {
}
