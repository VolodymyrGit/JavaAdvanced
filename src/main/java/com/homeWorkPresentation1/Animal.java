package com.homeWorkPresentation1;

public class Animal {
    private String animalType;
    private String animalAge;

    public Animal(String animalType, String animalAge) {
        this.animalType = animalType;
        this.animalAge = animalAge;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }
}
