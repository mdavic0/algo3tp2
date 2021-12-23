package edu.fiuba.algo3.modelo.pistas;

public class PistaDeCabello extends Pista{
    public PistaDeCabello(String cabello) {
        this.contenido = this.darFormato(cabello);
    }

    @Override
    String darFormato(String cabello) {
        return "Su cabello era".concat(cabello);
    }
}
