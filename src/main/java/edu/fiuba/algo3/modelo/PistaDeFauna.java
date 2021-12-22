package edu.fiuba.algo3.modelo;

public class PistaDeFauna extends Pista{
    public PistaDeFauna(String fauna){
        this.contenido = this.darFormato(fauna);
    }
    @Override
    String darFormato(String fauna) {
        return "Dijo que iba de visita a un pais en el que se pueden ver animales como ".concat(fauna).concat(".");
    }
}
