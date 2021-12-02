package edu.fiuba.algo3.modelo;

public abstract class LugarActual {

    public abstract LugarActual entrarA(IEdificio banco) throws Exception;

    public abstract LugarActual viajarA(IPais pais) throws Exception;

    public abstract IPais obtenerPais();

    public abstract String cuestionarTestigo() throws Exception ;
}
