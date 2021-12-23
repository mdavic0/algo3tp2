package edu.fiuba.algo3.modelo.pistas;

public class PistaDeCaracteristica extends Pista {

    public PistaDeCaracteristica(String caracteristica) {
        this.contenido = this.darFormato(caracteristica);
    }

    @Override
    String darFormato(String caracteristica) {
        return "Se dirigia a un pais reconocido por tener ".concat(caracteristica).concat(". ");
    }
}
