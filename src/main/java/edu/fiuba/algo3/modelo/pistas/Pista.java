package edu.fiuba.algo3.modelo.pistas;

import edu.fiuba.algo3.modelo.interfaces.IPista;

public abstract class Pista implements IPista { 
    String contenido;

    public String contenido(){
        return this.contenido;
    }

    abstract String darFormato(String contenido);
}

