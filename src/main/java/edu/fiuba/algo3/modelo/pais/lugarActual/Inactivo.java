package edu.fiuba.algo3.modelo.pais.lugarActual;

import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.excepciones.PoliciaNoInicializadoException;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;

public class Inactivo extends LugarActual {

    @Override
    public LugarActual entrarA(Edificio banco, Policia policia) throws AlgoThiefException {
        throw new PoliciaNoInicializadoException("Policia no inicializado");
    }

    @Override
    public LugarActual viajarA(Pais pais) throws AlgoThiefException {
        throw new PoliciaNoInicializadoException("Policia no inicializado");
    }

    @Override
    public Pais obtenerPais() {
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
