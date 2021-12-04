package edu.fiuba.algo3.modelo;

public class EnEdificio extends LugarActual {
    IEdificio edificio;

    public EnEdificio(IEdificio unEdificio) {
        this.edificio = unEdificio;
    }
    
    public LugarActual entrarA(IEdificio unEdificio, Policia policia) throws Exception {
        throw new Exception("No se puede entrar de un edificio a otro!");
    }

    @Override
    public String cuestionarTestigo() {
        return edificio.obtenerTestimonio();
    }

    public EnEdificio viajarA(IPais pais) throws Exception{
        throw new Exception("No puedo viajar estando adentro de un edificio!");
    }

    @Override
    public LugarActual salirDelEdificio() throws Exception {
        return new FueraDeEdificio(edificio.obtenerPais());
    }

    @Override
    public IPais obtenerPais() {
        return edificio.obtenerPais();
    }
    @Override
    public LugarActual salirDe(Edificio banco) throws Exception {
        return new FueraDeEdificio(edificio.obtenerPais());
    }

}
