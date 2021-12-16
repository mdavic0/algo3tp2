package edu.fiuba.algo3.modelo;

public abstract class LugarActual {

    public abstract LugarActual entrarA(IEdificio banco, Policia policia) throws Exception;

    public abstract LugarActual viajarA(IPais pais) throws Exception;

    public abstract IPais obtenerPais();

    public abstract LugarActual salirDelEdificio() throws Exception;

    public abstract String cuestionarTestigo() throws Exception ;

}
