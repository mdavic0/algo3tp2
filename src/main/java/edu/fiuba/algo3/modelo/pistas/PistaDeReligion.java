package edu.fiuba.algo3.modelo.pistas;

public class PistaDeReligion extends Pista{
    public PistaDeReligion(String religion) {
        this.contenido = this.darFormato(religion);
    }

    @Override
    String darFormato(String religion) {
        return "En el pais al que se dirigia se practica el ".concat(religion).concat(". ");
    }
}
