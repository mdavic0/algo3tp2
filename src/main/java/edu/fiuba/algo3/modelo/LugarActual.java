package edu.fiuba.algo3.modelo;

public abstract class LugarActual {
    public abstract LugarActual entrarA(Edificio unEdificio) throws Exception;

    public abstract Testigo obtenerTestigo() throws Exception;
}
