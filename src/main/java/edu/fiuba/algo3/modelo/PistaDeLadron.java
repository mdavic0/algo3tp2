package edu.fiuba.algo3.modelo;

public class PistaDeLadron extends Pista {

    public PistaDeLadron(String descripcion) {
        this.contenido = descripcion;
    }

    @Override
    public Object dificultad() {
        return new Media(); //TODO pistas de ladron de distinto tipo y dificultad;
    }

}
