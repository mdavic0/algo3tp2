package edu.fiuba.algo3.modelo.pistas;

public class PistaDeSenia extends Pista{
    public PistaDeSenia(String senia){
        this.contenido = this.darFormato(senia);
    }

    @Override
    public String darFormato(String senia) {
        return "La persona de la que me hablas tenia ".concat(senia).concat(". ");
    }
}
