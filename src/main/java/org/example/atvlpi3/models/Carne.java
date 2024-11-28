package org.example.atvlpi3.models;

public class Carne implements Alimento {
    String tipo;
    Double peso;
    String prato;

    //construtor
    public Carne (String tipo, double peso, String prato) {
        this.tipo = tipo;
        this.peso = peso;
        this.prato = prato;
    }

    //getters
    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public String getPrato() {
        return prato;
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
