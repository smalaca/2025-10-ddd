package com.smalaca.trainingdefinition.application.trainingidea;

import java.util.UUID;

public record CreateTrainingIdeaCommand(String name, String description, String category, UUID trainerId) {
}
