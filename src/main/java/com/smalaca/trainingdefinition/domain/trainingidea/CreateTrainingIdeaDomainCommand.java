package com.smalaca.trainingdefinition.domain.trainingidea;

public record CreateTrainingIdeaDomainCommand(String name, String description, Category category, TrainerId trainerId) {
}

