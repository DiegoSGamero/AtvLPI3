package org.example.atvlpi3.models;

public class Feline implements Animal {
    private String specie;
    private String habitat;
    private double weight;

    // Construtor
    public Feline(String species, String habitat, double weight) {
        this.specie = species;
        this.habitat = habitat;
        this.weight = weight;
    }

    //getters
    @Override
    public String getSpecies() {
        return specie;
    }

    @Override
    public String getHabitat() {
        return habitat;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    // Métodos adicionais da classe Feline
    public void makeSound() {
        System.out.println("O felino está rugindo ou miando!");
    }

    public void feed() {
        System.out.println("O felino está se alimentando de carne.");
    }

}
