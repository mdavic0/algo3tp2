package edu.fiuba.algo3.modelo.pistas;

public class PistaDeHobby extends Pista{
    public PistaDeHobby(String hobby) {
        this.contenido = this.darFormato(hobby);
    }

    @Override
    public String darFormato(String hobby) {
        return "Dijo que le gustaba practicar ".concat(hobby).concat(". ");
    }
}
