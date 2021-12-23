package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.policia.Policia;

public interface IRelacionConLadron {
    void herirConCuchillo(Policia policia);

    void herirConArmaDeFuego(Policia policia);

    void entrar(Policia policia);

    IPista crearPista();
}