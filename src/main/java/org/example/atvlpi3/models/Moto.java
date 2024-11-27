package org.example.atvlpi3.models;

public class Moto implements Automovel {
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
