package edu.fiuba.algo3.modelo.pistas;

public class PistaNoEstuvoEnEdificio extends Pista {

    public PistaNoEstuvoEnEdificio() {
        this.contenido = this.darFormato("");
    }

    @Override
    public String darFormato(String contenido) {
        return "Lo siento, no he visto a nadie parecido por esta zona...";
    }
}
