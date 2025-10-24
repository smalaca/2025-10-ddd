package com.smalaca.trainingdefinition.domain.trainingproposition;

// value object
public class Category {
    private final String category;

    private Category(String category) {
        this.category = category;
    }

    public static Category from(String category) {
        return new Category(category);
    }
}
