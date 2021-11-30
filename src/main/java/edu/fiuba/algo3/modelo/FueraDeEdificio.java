package edu.fiuba.algo3.modelo;

public class FueraDeEdificio extends LugarActual {

    Pais pais;

    public FueraDeEdificio(Pais pais) {// Pais pais
        this.pais = pais;
    }

    public LugarActual entrarA(Edificio unEdificio) throws Exception {

        if(!pais.contieneEdificio(unEdificio))
            throw new Exception("Ese edificio no existe.");

        unEdificio.nuevaVisita();

        return new EnEdificio(unEdificio);
    }

    @Override
    public Testigo obtenerTestigo() throws Exception {
        throw new Exception("No estás en un edificio!");
    }

    @Override
    public FueraDeEdificio viajarA(Pais pais) throws Exception {
        if(this.pais.sePuedeViajarA(pais)) return new FueraDeEdificio(pais);

        throw new Exception("No puedo viajar a ese pais!");
    }

    @Override
    public LugarActual salirDelEdificio() throws Exception {
        return null;
    }

    @Override
    public Pais obtenerPais() {
        return this.pais;
    }

}
