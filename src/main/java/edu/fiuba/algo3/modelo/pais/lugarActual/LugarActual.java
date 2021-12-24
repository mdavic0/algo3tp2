package edu.fiuba.algo3.modelo.pais.lugarActual;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;

public abstract class LugarActual {

    public abstract LugarActual entrarA(Edificio banco, Policia policia) throws Exception;

    public abstract LugarActual viajarA(Pais pais) throws Exception;

    public abstract Pais obtenerPais();

    public abstract LugarActual salirDelEdificio() throws Exception;

    public abstract String cuestionarTestigo() throws Exception ;

}
