package com.smalaca.trainingdefinition.application.trainingproposition;

import com.smalaca.trainingdefinition.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraftRepository;
import com.smalaca.trainingdefinition.domain.trainingproposition.Category;
import com.smalaca.trainingdefinition.domain.trainingproposition.CreateTrainingPropositionDomainCommand;
import com.smalaca.trainingdefinition.domain.trainingproposition.ReviewerId;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainerId;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainingProposition;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainingPropositionId;
import com.smalaca.trainingdefinition.domain.trainingproposition.TrainingPropositionRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingPropositionApplicationService {
    private final TrainingPropositionRepository trainingPropositionRepository;
    private final TrainingDraftRepository trainingDraftRepository;
    private final TrainersCatalogue trainersCatalogue;

    public TrainingPropositionApplicationService(TrainingPropositionRepository trainingPropositionRepository, TrainingDraftRepository trainingDraftRepository, TrainersCatalogue trainersCatalogue) {
        this.trainingPropositionRepository = trainingPropositionRepository;
        this.trainingDraftRepository = trainingDraftRepository;
        this.trainersCatalogue = trainersCatalogue;
    }

    @Transactional
    public UUID propose(CreateTrainingPropositionCommand command) {
        // 0-* - tłumaczenie języka:
        // - typy proste na value object
        // - identyfikatory na agregaty
        CreateTrainingPropositionDomainCommand domainCommand = new CreateTrainingPropositionDomainCommand(
                command.name(), command.description(), Category.from(command.category()), new TrainerId(command.trainerId()));

        // 1 - wykonanie operacji biznesowej
        TrainingProposition trainingProposition = TrainingProposition.create(domainCommand);

        // 1-* - zapis danych (zapis do warstwy persystencji albo/i opublikowanie zdarzeń)
        return trainingPropositionRepository.save(trainingProposition);
    }

    @Transactional
    public void accept(UUID trainingPropositionId, UUID reviewerId) {
        //
        ReviewerId reviewerIdVO = new ReviewerId(reviewerId);
        TrainingProposition trainingProposition = trainingPropositionRepository.findBy(new TrainingPropositionId(trainingPropositionId));

        //
        TrainingDraft trainingDraft = trainingProposition.accept(trainersCatalogue, reviewerIdVO);

        //
        trainingPropositionRepository.save(trainingProposition);
        trainingDraftRepository.save(trainingDraft);
    }
}
