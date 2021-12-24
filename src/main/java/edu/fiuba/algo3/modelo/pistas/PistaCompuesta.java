package edu.fiuba.algo3.modelo.pistas;

public class PistaCompuesta extends Pista{

    public PistaCompuesta(Pista unaPista, Pista otraPista) {
        this.contenido = this.darFormato(unaPista.contenido().concat(otraPista.contenido));
    }

    @Override
    public String darFormato(String contenido) {
        return contenido;
    }
}
