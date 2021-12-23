package edu.fiuba.algo3.modelo.pistas;

public class PistaDeBandera extends Pista {
    public PistaDeBandera(String coloresDeBandera) {
        this.contenido = this.darFormato(coloresDeBandera);
    }

    @Override
    String darFormato(String coloresDeBandera) {
        return "Se dirigia a un pais cuya bandera es de color ".concat(coloresDeBandera).concat(".");
    }
}
