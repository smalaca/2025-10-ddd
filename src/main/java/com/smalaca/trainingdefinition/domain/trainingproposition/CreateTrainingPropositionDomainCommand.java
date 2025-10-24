package com.smalaca.trainingdefinition.domain.trainingproposition;

public record CreateTrainingPropositionDomainCommand(String name, String description, Category category, TrainerId trainerId) {
}

