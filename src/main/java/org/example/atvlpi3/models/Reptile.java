package org.example.atvlpi3.models;

import java.util.Date;

public class Reptile implements Animal {
    //private int id;
    private String species;
    private String habitat;
    private double weight;

    //construtor
    public Reptile(String species, String habitat, double weight) {
        this.species = species;
        this.habitat = habitat;
        this.weight = weight;
    }

    //getters
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

    //setters
    public void setSpecies(String species) { this.species = species; }
    public void setNumSprint(String habitat) { this.habitat = habitat; }
    public void setWeight(double weight) { this.habitat = habitat; }
}
