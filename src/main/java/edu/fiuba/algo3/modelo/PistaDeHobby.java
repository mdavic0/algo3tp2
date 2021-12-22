package edu.fiuba.algo3.modelo;

public class PistaDeHobby extends Pista{
    public PistaDeHobby(String hobby) {
        this.contenido = this.darFormato(hobby);
    }

    @Override
    String darFormato(String hobby) {
        return "Dijo que le gustaba ".concat(hobby);
    }
}
