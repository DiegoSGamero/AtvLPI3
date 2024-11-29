package org.example.atvlpi3.models;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

    public void rugir() {
        String caminho = getClass().getResource("/Sounds/rugido.wav").toExternalForm();
        Media som = new Media(caminho);
        MediaPlayer mediaPlayer = new MediaPlayer(som);
        mediaPlayer.play();
    }

}
