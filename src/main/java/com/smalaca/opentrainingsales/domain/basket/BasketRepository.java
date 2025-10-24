package com.smalaca.opentrainingsales.domain.basket;

// repository
public interface BasketRepository {
    Basket findBy(BasketId basketId);

    void save(Basket basket);
}
