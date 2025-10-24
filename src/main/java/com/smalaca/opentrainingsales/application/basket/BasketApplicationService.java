package com.smalaca.opentrainingsales.application.basket;

import com.smalaca.opentrainingsales.domain.basket.Basket;
import com.smalaca.opentrainingsales.domain.basket.BasketId;
import com.smalaca.opentrainingsales.domain.basket.BasketRepository;
import com.smalaca.opentrainingsales.domain.trainingid.TrainingId;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class BasketApplicationService {
    private final BasketRepository basketRepository;

    public BasketApplicationService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Transactional
    public void addTraining(UUID basketId, UUID trainingId) {
        Basket basket = basketRepository.findBy(new BasketId(basketId));
        TrainingId trainingIdVO = new TrainingId(trainingId);

        basket.add(trainingIdVO);

        basketRepository.save(basket);
    }
}
