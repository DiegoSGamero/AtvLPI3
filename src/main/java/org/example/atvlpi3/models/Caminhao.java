package org.example.atvlpi3.models;

public class Caminhao implements Automovel {
    @Override
    public void ligar() {
        System.out.println("vrum-vrum-vrum");
    }

    @Override
    public void acelerar() {
        System.out.println("vruuuuuuuuuhhhh");
    }

    @Override
    public void freiar() {
        System.out.println("tsssshhhhhh");
    }
}
