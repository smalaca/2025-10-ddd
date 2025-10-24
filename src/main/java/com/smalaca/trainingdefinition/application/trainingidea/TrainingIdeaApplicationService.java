package com.smalaca.trainingdefinition.application.trainingidea;

import com.smalaca.trainingdefinition.domain.trainingidea.Category;
import com.smalaca.trainingdefinition.domain.trainingidea.CreateTrainingIdeaDomainCommand;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainerId;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainingIdea;
import com.smalaca.trainingdefinition.domain.trainingidea.TrainingIdeaRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingIdeaApplicationService {
    private final TrainingIdeaRepository trainingIdeaRepository;

    public TrainingIdeaApplicationService(TrainingIdeaRepository trainingIdeaRepository) {
        this.trainingIdeaRepository = trainingIdeaRepository;
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
}
