package homework_07.task_02;


import java.io.Serializable;

public class Animal implements Serializable {

    private String animal;
    private String habitat;  // ареал обитания
    private String classification; // классификация
    private DataAnimal dataAnimal;

    public Animal(String animal, String habitat, String classification, DataAnimal dataAnimal) {
        this.animal = animal;
        this.habitat = habitat;
        this.classification = classification;
        this.dataAnimal = dataAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animal='" + animal + '\'' +
                ", habitat='" + habitat + '\'' +
                ", classification='" + classification + '\'' +
                ", dataAnimal=" + dataAnimal +
                '}';
    }
}

class DataAnimal implements Serializable {

    private String animalName;
    private int animalWeight;
    private double animalSped;

    public DataAnimal(String animalName, int animalWeight, double animalSped) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.animalSped = animalSped;
    }

    @Override
    public String toString() {
        return "DataAnimal{" +
                "animalName='" + animalName + '\'' +
                ", animalWeight=" + animalWeight +
                ", animalSped=" + animalSped +
                '}';
    }
}
