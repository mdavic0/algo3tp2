package edu.fiuba.algo3.modelo;

public class FueraDeEdificio extends LugarActual {

    IPais pais;

    public FueraDeEdificio(IPais pais) {// Pais pais
        this.pais = pais;
    }

    public LugarActual entrarA(IEdificio unEdificio) throws Exception {
        if(!pais.contieneEdificio(unEdificio))
            throw new Exception("Ese edificio no existe.");
        unEdificio.entrar();
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
    public LugarActual salirDelEdificio() throws Exception {
        return null;
    }

    @Override
    public IPais obtenerPais() {
        return this.pais;
    }

    //TODO quitar argumento
    @Override
    public LugarActual salirDe(Edificio edificio) throws Exception {
        throw new Exception("Ya estas afuera");
    }

}
