package edu.fiuba.algo3.modelo;


public interface IRelacionConLadron {
    void herirConCuchillo(Policia policia);

    void herirConArmaDeFuego(Policia policia);

    void entrar(Policia policia);

    IPista crearPista();
}