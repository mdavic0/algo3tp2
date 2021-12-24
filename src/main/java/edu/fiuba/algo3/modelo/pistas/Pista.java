package edu.fiuba.algo3.modelo.pistas;

public abstract class Pista {
    String contenido;

    public String contenido(){
        return this.contenido;
    }

    public abstract String darFormato(String contenido);
}

