package com.smalaca.trainingdefinition.application.trainingdraft;

import com.smalaca.trainingdefinition.domain.trainingdraft.Price;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraftId;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraftRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class TrainingDraftApplicationService {
    private final TrainingDraftRepository trainingDraftRepository;

    public TrainingDraftApplicationService(TrainingDraftRepository trainingDraftRepository) {
        this.trainingDraftRepository = trainingDraftRepository;
    }

    public void modify(UUID trainingDraftId, BigDecimal price, int trainingDays) {
        TrainingDraft trainingDraft = trainingDraftRepository.findById(new TrainingDraftId(trainingDraftId));
        Price priceVO = Price.from(price);

        trainingDraft.update(priceVO, trainingDays);

        trainingDraftRepository.save(trainingDraft);
    }
}
