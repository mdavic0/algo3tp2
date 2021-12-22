package edu.fiuba.algo3.modelo;

public class PistaDeSenia extends Pista{
    public PistaDeSenia(String senia){
        this.contenido = this.darFormato(senia);
    }

    @Override
    String darFormato(String senia) {
        return senia.concat(".");
    }
}
