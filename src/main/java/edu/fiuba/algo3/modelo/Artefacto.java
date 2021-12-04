package edu.fiuba.algo3.modelo;

public class Artefacto {
    String nombre;
    public Artefacto(String string) {
        this.nombre = string;
    }

    public String toString(){
        return nombre;
    }

    public Valor valor() {
        return new MuyValioso();
    }

}
