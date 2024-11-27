package org.example.atvlpi3.models;

public class Moto implements Automovel {
    String marca;
    String modelo;
    String cor;

    //construtor
    public Moto (String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    //getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    //setters
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCor(String cor) { this.cor = cor; }

    @Override
    public void ligar() {
        System.out.println("vrummm-vrummm");
    }

    @Override
    public void acelerar() {
        System.out.println("ren ten ten");
    }

    @Override
    public void freiar() {
        System.out.println("eiiiiik");
    }
}
