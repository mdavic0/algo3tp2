package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pistas.Pista;

public class PistaMock extends Pista {
    String pista;

    public PistaMock(String string) {
        pista = string;
    }

    @Override
    public String darFormato(String contenido) {
        return null;
    }

}
