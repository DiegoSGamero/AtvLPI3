package org.example.atvlpi3.models;

public class Bird {
    private String specie;
    private String habitat;
    private double weight;

    // Construtor
    public Bird(String species, String habitat, double weight) {
        this.specie = species;
        this.habitat = habitat;
        this.weight = weight;
    }

    //getters
    //@Override
    public String getSpecies() {
        return specie;
    }

    //@Override
    public String getHabitat() {
        return habitat;
    }

    //@Override
    public double getWeight() {
        return weight;
    }

    //setters
    public void setSpecie(String species) { this.specie = species; }
    public void setNumSprint(String habitat) { this.habitat = habitat; }
    public void setWeight(double weight) { this.habitat = habitat; }

    // Métodos adicionais da classe Bird
    public void makeSound() {
        System.out.println("AAAAA  aaaa  AAAA!");
    }

    public void feed() {
        System.out.println("Nhac nhac");
    }


}
