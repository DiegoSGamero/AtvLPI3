package org.example.atvlpi3.models;

public class Reptile implements Animal {
    private String species;
    private String habitat;
    private double weight;

    public Reptile(String species, String habitat, double weight) {
        this.species = species;
        this.habitat = habitat;
        this.weight = weight;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public String getHabitat() {
        return habitat;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
