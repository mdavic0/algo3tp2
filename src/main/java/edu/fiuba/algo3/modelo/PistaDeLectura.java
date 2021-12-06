package edu.fiuba.algo3.modelo;

public class PistaDeLectura extends Pista {

    public PistaDeLectura(String libro) {
        this.contenido = "Quería leer el libro ".concat(libro).concat(".");
    }

    @Override
    public Object dificultad() {
        return new Dificil();
    }

}
