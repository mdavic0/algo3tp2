package edu.fiuba.algo3.modelo;

public class Artefacto {
    String nombre;
    Valor valor;
    public Artefacto(String string, Valor valor) {
        this.nombre = string;
        this.valor = valor;
    }

    public String toString(){
        return nombre;
    }

    public Valor valor() {
        return valor;
    }

}
