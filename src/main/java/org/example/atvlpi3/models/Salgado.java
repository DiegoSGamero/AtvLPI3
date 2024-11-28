package org.example.atvlpi3.models;

public class Salgado implements Alimento {
    String tipo;
    Double peso;
    String sabor;

    //construtor
    public Salgado (String tipo, double peso, String sabor) {
        this.tipo = tipo;
        this.peso = peso;
        this.sabor = sabor;
    }

    //getters
    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public String getSabor() {
        return sabor;
    }

    @Override
    public void comprar() {

    }

    @Override
    public void cozinhar() {

    }

    @Override
    public void comer() {

    }
}
