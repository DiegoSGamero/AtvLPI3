package org.example.atvlpi3.models;

public class Feline implements Animal {
    private String species;
    private String habitat;
    private double weight;
    private double maxSpeed;

    // Construtor
    public Feline(String species, String habitat, double weight, String furColor, double maxSpeed) {
        this.species = species;
        this.habitat = habitat;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    // Métodos da interface
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

    // Métodos adicionais da classe Feline
    public void makeSound() {
        System.out.println("O felino está rugindo ou miando!");
    }

    public void move() {
        System.out.println("O felino está se movendo rapidamente com uma velocidade de " + maxSpeed + " km/h.");
    }

    public void feed() {
        System.out.println("O felino está se alimentando de carne.");
    }

    // Getters e setters

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
