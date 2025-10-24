package com.smalaca.trainingdefinition.application.trainingidea;

import com.smalaca.trainingdefinition.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingdefinition.domain.trainingdraft.TrainingDraftRepository;
import com.smalaca.trainingdefinition.domain.trainingidea.Category;
import com.smalaca.trainingdefinition.domain.trainingidea.CreateTrainingIdeaDomainCommand;
import com.smalaca.trainingdefinition.domain.trainingidea.ReviewerId;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainerId;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainingIdea;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainingIdeaId;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainingIdeaRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingIdeaApplicationService {
    private final TrainingIdeaRepository trainingIdeaRepository;
    private final TrainingDraftRepository trainingDraftRepository;
    private final TrainersCatalogue trainersCatalogue;

    public TrainingIdeaApplicationService(TrainingIdeaRepository trainingIdeaRepository, TrainingDraftRepository trainingDraftRepository, TrainersCatalogue trainersCatalogue) {
        this.trainingIdeaRepository = trainingIdeaRepository;
        this.trainingDraftRepository = trainingDraftRepository;
        this.trainersCatalogue = trainersCatalogue;
    }

    @Transactional
    public UUID propose(CreateTrainingIdeaCommand command) {
        // 0-* - tłumaczenie języka:
        // - typy proste na value object
        // - identyfikatory na agregaty
        CreateTrainingIdeaDomainCommand domainCommand = new CreateTrainingIdeaDomainCommand(
                command.name(), command.description(), Category.from(command.category()), new TrainerId(command.trainerId()));

        // 1 - wykonanie operacji biznesowej
        TrainingIdea trainerIdea = TrainingIdea.create(domainCommand);

        // 1-* - zapis danych (zapis do warstwy persystencji albo/i opublikowanie zdarzeń)
        return trainingIdeaRepository.save(trainerIdea);
    }

    @Transactional
    public void accept(UUID trainingIdeaId, UUID reviewerId) {
        //
        ReviewerId reviewerIdVO = new ReviewerId(reviewerId);
        TrainingIdea trainingIdea = trainingIdeaRepository.findBy(new TrainingIdeaId(trainingIdeaId));

        //
        TrainingDraft trainingDraft = trainingIdea.accept(trainersCatalogue, reviewerIdVO);

        //
        trainingIdeaRepository.save(trainingIdea);
        trainingDraftRepository.save(trainingDraft);
    }
}
