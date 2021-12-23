package edu.fiuba.algo3.modelo.pistas;

public class PistaDeRepresentante extends Pista{
    public PistaDeRepresentante(String representante) {
        this.contenido = this.darFormato(representante);
    }
    @Override
    String darFormato(String representante) {
        return "Se dirigia a un pais cuyo sistema representativo esta encabezado por un ".concat(representante).concat(". ");
    }
}
