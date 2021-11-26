package edu.fiuba.algo3.modelo;

public class EnEdificio extends LugarActual {
    Edificio edificio;
    public EnEdificio(Edificio unEdificio) {
        this.edificio = unEdificio;
    }
    public LugarActual entrarA(Edificio unEdificio) throws Exception {
        throw new Exception("No se puede entrar de un edificio a otro!");
    }
    @Override
    public Testigo obtenerTestigo() {
        return this.edificio.obtenerTestigo();
    }

    public EnEdificio viajarA(Pais pais) throws Exception{
        throw new Exception("No puedo viajar estando adentro de un edificio!");
    }

    @Override
    public Pais obtenerPais() {
        return edificio.obtenerPais();
    }

}
