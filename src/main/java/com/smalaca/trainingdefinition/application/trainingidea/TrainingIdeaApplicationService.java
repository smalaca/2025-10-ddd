package com.smalaca.trainingdefinition.application.trainingidea;

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
    public UUID propose(UUID trainerId) {
        // 0-* - tłumaczenie języka:
        // - typy proste na value object
        // - identyfikatory na agregaty
        TrainerId trainerIdVO = new TrainerId(trainerId);

        // 1 - wykonanie operacji biznesowej 
        TrainingIdea trainerIdea = TrainingIdea.create(trainerIdVO);

        // 1-* - zapis danych (zapis do warstwy persystencji albo/i opublikowanie zdarzeń)
        return trainingIdeaRepository.save(trainerIdea);
    }
}
