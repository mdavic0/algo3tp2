package edu.fiuba.algo3.modelo;

public class Pista {

    TipoDePista tipoDePista;
    String contenido;

    public Pista(String unaPista, TipoDePista untipo) {
        this.contenido = unaPista;
        this.tipoDePista = untipo;
    }

    public String obtenerContenido(){
        return this.contenido;
    }

    public Pista(String contenido){
        this.contenido = contenido;
        this.tipoDePista = new PistaEconomica();
    }
    public String contenido() {
        return contenido;
    }
}
