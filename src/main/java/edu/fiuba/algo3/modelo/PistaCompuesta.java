package edu.fiuba.algo3.modelo;

public class PistaCompuesta extends Pista{

    public PistaCompuesta(Pista unaPista, Pista otraPista) {
        this.contenido = unaPista.contenido().concat(otraPista.contenido);
    }

}
