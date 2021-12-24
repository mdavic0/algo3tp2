package edu.fiuba.algo3.modelo.pistas;

public class PistaLadronEstaCerca extends Pista {

    public PistaLadronEstaCerca() {
        this.contenido = this.darFormato("");
    }

    @Override
    public String darFormato(String contenido) {
        return "Cuidado, la persona que buscas esta MUY cerca!!";
    }
}