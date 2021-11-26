package edu.fiuba.algo3.modelo;

public abstract class LugarActual {

    public abstract LugarActual entrarA(Edificio unEdificio) throws Exception;

    public abstract Testigo obtenerTestigo() throws Exception;

    public abstract LugarActual viajarA(Pais pais) throws Exception;

    public abstract Pais obtenerPais();
}
