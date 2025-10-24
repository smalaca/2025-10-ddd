package com.smalaca.trainingdefinition.application.trainingproposition;

import java.util.UUID;

public record CreateTrainingPropositionCommand(String name, String description, String category, UUID trainerId) {
}
