package edu.fiuba.algo3.modelo;

public class PistaDeMoneda extends Pista {
    public PistaDeMoneda(String moneda) {
        this.contenido = this.darFormato(moneda);
    }

    @Override
    String darFormato(String moneda) {
        return "Quería cambiar su dinero por ".concat(moneda).concat(".");
    }
}
