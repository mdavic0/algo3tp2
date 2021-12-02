package edu.fiuba.algo3.modelo;

public class FueraDeEdificio extends LugarActual {
    IPais pais;
    public FueraDeEdificio(IPais colombia) {// Pais pais
        this.pais = colombia;
    }
    public LugarActual entrarA(IEdificio unEdificio) throws Exception {
        if(!pais.contieneEdificio(unEdificio))
            throw new Exception("Ese edificio no existe.");
        return new EnEdificio(unEdificio);
    }
    @Override
    public String cuestionarTestigo() throws Exception {
        throw new Exception("No estás en un edificio!");
    }

    @Override
    public FueraDeEdificio viajarA(IPais pais) throws Exception {
        if(this.pais.sePuedeViajarA(pais)) return new FueraDeEdificio(pais);

        throw new Exception("No puedo viajar a ese pais!");
    }

    @Override
    public IPais obtenerPais() {
        return this.pais;
    }

}
