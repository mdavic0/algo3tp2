package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AccionInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;

public class EnEdificio extends LugarActual {
    IEdificio edificio;

    public EnEdificio(IEdificio unEdificio) {
        this.edificio = unEdificio;
    }

    @Override
    public String cuestionarTestigo() {
        return edificio.obtenerTestimonio();
    }

    @Override
    public LugarActual entrarA(IEdificio banco, Policia policia) throws AlgoThiefException {
        throw new AccionInvalidaException("No se puede entrar de un edificio a otro!");
    }

    public EnEdificio viajarA(IPais pais) throws AlgoThiefException {
        throw new AccionInvalidaException("No puedo viajar estando adentro de un edificio!");
    }

    @Override
    public LugarActual salirDelEdificio() {
        return new FueraDeEdificio(edificio.obtenerPais());
    }

    @Override
    public IPais obtenerPais() {
        return edificio.obtenerPais();
    }

}
