package org.example.atvlpi3.models;

public class Carro implements Automovel {
    @Override
    public void ligar() {
        System.out.println("vruuum");
    }

    @Override
    public void acelerar() {
        System.out.println("vrrrrrooooom");
    }

    @Override
    public void freiar() {
        System.out.println(" iiiiiissshhh");
    }
}
