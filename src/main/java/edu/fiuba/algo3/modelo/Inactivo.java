package edu.fiuba.algo3.modelo;

public class Inactivo extends LugarActual{

    @Override
    public LugarActual entrarA(IEdificio banco, Policia policia) throws Exception {
        throw new Exception("Policia no inicializado");
    }

    @Override
    public LugarActual viajarA(IPais pais) throws Exception {
        throw new Exception("Policia no inicializado");
    }

    @Override
    public IPais obtenerPais() {
        return null;
    }

    @Override
    public LugarActual salirDelEdificio() throws Exception {
        throw new Exception("Policia no inicializado");
    }

    @Override
    public String cuestionarTestigo() throws Exception {
        throw new Exception("Policia no inicializado");
    }

    @Override
    public LugarActual salirDe(IEdificio banco) throws Exception {
        throw new Exception("Policia no inicializado");
    }
    
}
