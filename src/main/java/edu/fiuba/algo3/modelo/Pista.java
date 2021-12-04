package edu.fiuba.algo3.modelo;

public class Pista {

    ITipoDePista tipoDePista;
    String contenido;

    public Pista(String unaPista, ITipoDePista untipo) {
        this.contenido = unaPista;
        this.tipoDePista = untipo;
    }

    public Pista(String contenido){
        this.contenido = contenido;
        this.tipoDePista = new PistaEconomica();
    }

    public String obtenerContenido(){
        return this.contenido;
    }

    public String contenido() {
        return contenido;
    }
}
