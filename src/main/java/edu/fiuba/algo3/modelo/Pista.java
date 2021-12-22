package edu.fiuba.algo3.modelo;

public abstract class Pista implements IPista { 
    String contenido;

    public String contenido(){
        return this.contenido;
    }

    abstract String darFormato(String contenido);
}

