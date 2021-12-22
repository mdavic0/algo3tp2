package edu.fiuba.algo3.modelo;

public class PistaDeEtnia extends Pista{
    public PistaDeEtnia(String etnia){
        this.contenido = this.darFormato(etnia);
    }

    @Override
    String darFormato(String etnia) {
        return "Se dirigia a un pais reconocido por tener etnias como ".concat(etnia).concat(".");
    }
}
