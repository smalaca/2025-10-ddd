package com.smalaca.trainingdefinition.infrastructure.adapter.out.trainerscatalogue;

import com.smalaca.trainingdefinition.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingdefinition.domain.trainingproposition.Category;
import com.smalaca.trainingdefinition.domain.trainingproposition.ReviewerId;

public class RestTrainersCatalogue implements TrainersCatalogue {
    @Override
    public boolean canValidate(ReviewerId reviewerId, Category category) {
        // łączymy się po https z serwerem
        return false;
    }
}
