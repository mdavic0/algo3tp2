package edu.fiuba.algo3.modelo.pistas;

public class PistaDeIndustria extends Pista{
    public PistaDeIndustria(String industrias){
        this. contenido = this.darFormato(industrias);
    }

    @Override
    public String darFormato(String industrias) {
        return "Se dirigia a un pais destacado por la produccion de ".concat(industrias).concat(". ");
    }
}
