package com.smalaca.opentrainingsales.application.basket;

import com.smalaca.opentrainingsales.domain.basket.Basket;
import com.smalaca.opentrainingsales.domain.basket.BasketId;
import com.smalaca.opentrainingsales.domain.basket.BasketRepository;
import com.smalaca.opentrainingsales.domain.training.ParticipantId;
import com.smalaca.opentrainingsales.domain.training.Training;
import com.smalaca.opentrainingsales.domain.training.TrainingRepository;
import com.smalaca.opentrainingsales.domain.trainingid.TrainingId;
import com.smalaca.opentrainingsales.domain.trainingregistration.TrainingRegistrationDomainService;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class BasketApplicationService {
    private final BasketRepository basketRepository;
    private final TrainingRepository trainingRepository;
    private final TrainingRegistrationDomainService trainingRegistrationDomainService;

    public BasketApplicationService(BasketRepository basketRepository, TrainingRepository trainingRepository, TrainingRegistrationDomainService trainingRegistrationDomainService) {
        this.basketRepository = basketRepository;
        this.trainingRepository = trainingRepository;
        this.trainingRegistrationDomainService = trainingRegistrationDomainService;
    }

    @Transactional
    public void addTraining(UUID basketId, UUID trainingId) {
        Basket basket = basketRepository.findBy(new BasketId(basketId));
        TrainingId trainingIdVO = new TrainingId(trainingId);

        basket.add(trainingIdVO);

        basketRepository.save(basket);
    }

    @Transactional
    public void removeTraining(UUID basketId, UUID trainingId) {
        Basket basket = basketRepository.findBy(new BasketId(basketId));
        TrainingId trainingIdVO = new TrainingId(trainingId);

        basket.remove(trainingIdVO);

        basketRepository.save(basket);
    }

    @Transactional
    public void registerForTraining(UUID participantId, UUID basketId, UUID trainingId) {
        ParticipantId participantIdVO = new ParticipantId(participantId);
        Basket basket = basketRepository.findBy(new BasketId(basketId));
        Training training = trainingRepository.findBy(new TrainingId(trainingId));

        trainingRegistrationDomainService.registerFor(basket, training, participantIdVO);

        basketRepository.save(basket);
        trainingRepository.save(training);
    }
}
