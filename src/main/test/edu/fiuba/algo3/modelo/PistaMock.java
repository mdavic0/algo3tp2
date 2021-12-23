package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interfaces.IPista;

public class PistaMock implements IPista {
    String pista;
    public PistaMock(String string) {
        pista = string;
    }

    @Override
    public String contenido() {
        return pista;
    }
    
}
