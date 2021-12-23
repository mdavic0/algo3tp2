package edu.fiuba.algo3.modelo.pistas;

public class PistaDeIdioma extends Pista {
    public PistaDeIdioma(String idioma) {
        this.contenido = this.darFormato(idioma);
    }

    @Override
    String darFormato(String idioma) {
        return "Se dirigia a un pais en el que hablan ".concat(idioma).concat(". ");
    }
}
