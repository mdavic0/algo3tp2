package edu.fiuba.algo3.modelo.pistas;

public class PistaDeArte extends Pista{
    public PistaDeArte(String arte){
        this.contenido = darFormato(arte);
    }

    @Override
    String darFormato(String arte) {
        return "Estaba feliz porque se dirigia a conocer ".concat(arte).concat(". ");
    }
}
