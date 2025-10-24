package com.smalaca.opentrainingsales.domain.order;

// repository
public interface OrderRepository {
    Order findBy(OrderId orderId);

    void save(Order order);
}
