package edu.fiuba.algo3.modelo;


public interface IRelacionConLadron {
    void herirConCuchillo(Policia policia) throws Exception;

    void herirConArmaDeFuego(Policia policia) throws Exception;

    void entrar(Policia policia) throws Exception;

    IPista crearPista();
}