package edu.fiuba.algo3.modelo.pais.lugarActual;

import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.policia.Policia;

public abstract class LugarActual {

    public abstract LugarActual entrarA(IEdificio banco, Policia policia) throws Exception;

    public abstract LugarActual viajarA(IPais pais) throws Exception;

    public abstract IPais obtenerPais();

    public abstract LugarActual salirDelEdificio() throws Exception;

    public abstract String cuestionarTestigo() throws Exception ;

}
