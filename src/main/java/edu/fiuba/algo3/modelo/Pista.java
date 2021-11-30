package edu.fiuba.algo3.modelo;

public class Pista {

    String contenido = null;
    TipoDePista tipoDePista;

    public Pista(String unaPista, TipoDePista untipo) {
        this.contenido = unaPista;
        this.tipoDePista = untipo;
    }

    public String obtenerContenido(){
        return this.contenido;
    }

}
