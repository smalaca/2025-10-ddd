package com.smalaca.trainingdefinition.domain.trainerscatalogue;

import com.smalaca.trainingdefinition.domain.trainingproposition.Category;
import com.smalaca.trainingdefinition.domain.trainingproposition.ReviewerId;

// Port
public interface TrainersCatalogue {
    boolean canValidate(ReviewerId reviewerId, Category category);
}
