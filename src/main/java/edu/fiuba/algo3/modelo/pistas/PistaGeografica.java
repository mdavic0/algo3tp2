package edu.fiuba.algo3.modelo.pistas;

public class PistaGeografica extends Pista {

    public PistaGeografica(String geografia) {
        this.contenido = this.darFormato(geografia);
    }

    @Override
    public String darFormato(String geografia) {
        return "Se dirigia a un pais que se caracteriza geograficamente por tener ".concat(geografia).concat(". ");
    }
}
