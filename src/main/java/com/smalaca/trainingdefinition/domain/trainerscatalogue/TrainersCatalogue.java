package com.smalaca.trainingdefinition.domain.trainerscatalogue;

import com.smalaca.trainingdefinition.domain.trainingidea.Category;
import com.smalaca.trainingdefinition.domain.trainingidea.ReviewerId;

// Port
public interface TrainersCatalogue {
    boolean canValidate(ReviewerId reviewerId, Category category);
}
