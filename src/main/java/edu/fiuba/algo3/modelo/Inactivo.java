package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.excepciones.PoliciaNoInicializadoException;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;

public class Inactivo extends LugarActual{

    @Override
    public LugarActual entrarA(IEdificio banco, Policia policia) throws AlgoThiefException {
        throw new PoliciaNoInicializadoException("Policia no inicializado");
    }

    @Override
    public LugarActual viajarA(IPais pais) throws AlgoThiefException {
        throw new PoliciaNoInicializadoException("Policia no inicializado");
    }

    @Override
    public IPais obtenerPais() {
        return null;
    }

    @Override
    public LugarActual salirDelEdificio() throws AlgoThiefException {
        throw new PoliciaNoInicializadoException("Policia no inicializado");
    }

    @Override
    public String cuestionarTestigo() throws AlgoThiefException {
        throw new PoliciaNoInicializadoException("Policia no inicializado");
    }

    
}
