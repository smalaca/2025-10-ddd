package com.smalaca.opentrainingsales.application.order;

import com.smalaca.opentrainingsales.domain.eventpublisher.EventPublisher;
import com.smalaca.opentrainingsales.domain.invoice.InvoiceRepository;
import com.smalaca.opentrainingsales.domain.order.Order;
import com.smalaca.opentrainingsales.domain.order.OrderId;
import com.smalaca.opentrainingsales.domain.order.OrderRepository;
import com.smalaca.opentrainingsales.domain.order.events.TrainingPaidResult;

import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final InvoiceRepository invoiceRepository;
    private final EventPublisher eventPublisher;

    public OrderApplicationService(OrderRepository orderRepository, InvoiceRepository invoiceRepository, EventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
        this.eventPublisher = eventPublisher;
    }

    public void pay(UUID orderId) {
        Order order = orderRepository.findBy(new OrderId(orderId));

        TrainingPaidResult result = order.pay();

        orderRepository.save(order);
        invoiceRepository.save(result.invoice());
        eventPublisher.publish(result.trainingPaidDomainEvent());
    }
}
