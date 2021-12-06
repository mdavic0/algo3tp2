package edu.fiuba.algo3.modelo;

public class Pista implements IPista { 
    String contenido;

    public Pista(String string) {
        this.contenido = string;
    }

    public String contenido(){
        return this.contenido;
    }
}
