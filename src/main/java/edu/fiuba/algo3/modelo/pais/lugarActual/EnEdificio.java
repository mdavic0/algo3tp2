package edu.fiuba.algo3.modelo.pais.lugarActual;

import edu.fiuba.algo3.modelo.excepciones.AccionInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;

public class EnEdificio extends LugarActual {
    Edificio edificio;

    public EnEdificio(Edificio unEdificio) {
        this.edificio = unEdificio;
    }

    @Override
    public String cuestionarTestigo() {
        return edificio.obtenerTestimonio();
    }

    @Override
    public LugarActual entrarA(Edificio banco, Policia policia) throws AlgoThiefException {
        throw new AccionInvalidaException("No se puede entrar de un edificio a otro!");
    }

    public EnEdificio viajarA(Pais pais) throws AlgoThiefException {
        throw new AccionInvalidaException("No puedo viajar estando adentro de un edificio!");
    }

    @Override
    public LugarActual salirDelEdificio() {
        return new FueraDeEdificio(edificio.obtenerPais());
    }

    @Override
    public Pais obtenerPais() {
        return edificio.obtenerPais();
    }

}
