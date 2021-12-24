package edu.fiuba.algo3.modelo.pais.lugarActual;

import edu.fiuba.algo3.modelo.excepciones.AccionInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;

public class FueraDeEdificio extends LugarActual {

    Pais pais;

    public FueraDeEdificio(Pais pais) {// Pais pais
        this.pais = pais;
    }

    public LugarActual entrarA(Edificio unEdificio, Policia policia) throws AlgoThiefException {
        if(!pais.contieneEdificio(unEdificio))
            throw new AccionInvalidaException("Ese edificio no existe.");
        unEdificio.entrar(policia);
        return new EnEdificio(unEdificio);
    }

    @Override
    public String cuestionarTestigo() throws AlgoThiefException {
        throw new AccionInvalidaException("No estás en un edificio!");
    }

    @Override
    public FueraDeEdificio viajarA(Pais pais) throws AlgoThiefException {
        if(this.pais.sePuedeViajarA(pais)) return new FueraDeEdificio(pais);

        throw new AccionInvalidaException("No puedo viajar a ese pais!");
    }

    @Override
    public LugarActual salirDelEdificio() throws AlgoThiefException {
        throw new AccionInvalidaException("Ya estas afuera!");
    }

    @Override
    public Pais obtenerPais() {
        return this.pais;
    }

}
