package com.smalaca.opentrainingsales.domain.invoice;

import com.smalaca.opentrainingsales.domain.order.OrderId;

// aggregate root
public class Invoice {
    private final InvoiceNumber invoiceNumber;
    private final OrderId orderId;

    private Invoice(InvoiceNumber invoiceNumber, OrderId orderId) {
        this.invoiceNumber = invoiceNumber;
        this.orderId = orderId;
    }

    public static Invoice create(OrderId orderId) {
        return new Invoice(InvoiceNumber.create(), orderId);
    }

    public InvoiceNumber getInvoiceNumber() {
        return invoiceNumber;
    }
}
