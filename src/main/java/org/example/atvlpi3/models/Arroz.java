package org.example.atvlpi3.models;

public class Arroz implements Alimento{
    String tipo;
    Double peso;
    String prato;

    //construtor
    public Arroz (String tipo, double peso, String prato) {
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
        System.out.println("dim dim");
    }

    @Override
    public void cozinhar() {
        System.out.println("cuidado com o calor da panela");
    }

    @Override
    public void comer() {
        System.out.println("nhammmm");
    }
}
