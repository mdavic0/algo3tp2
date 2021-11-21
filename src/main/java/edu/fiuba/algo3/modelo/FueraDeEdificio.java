package edu.fiuba.algo3.modelo;

public class FueraDeEdificio extends LugarActual {
    Pais pais;
    public FueraDeEdificio(Pais pais) {// Pais pais
        this.pais = pais;
    }
    public LugarActual entrarA(Edificio unEdificio) throws Exception {
        if(!pais.contieneEdificio(unEdificio))
            throw new Exception("Ese edificio no existe.");
        return new EnEdificio(unEdificio);
    }
    @Override
    public Testigo obtenerTestigo() throws Exception {
        throw new Exception("No estás en un edificio!");
    }
}
