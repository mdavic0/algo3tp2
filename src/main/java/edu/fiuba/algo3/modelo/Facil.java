package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.excepciones.PistaException;

public class Facil implements Dificultad {

    @Override
    public Pista crearPistaEconomica(IPais pais) {
        return new PistaDeMoneda(pais.moneda());
    }

    @Override
    public Pista crearPistaDeLectura(IPais pais) throws AlgoThiefException {
        throw new PistaException("No hay pistas fáciles para este tipo de edificio");
    }

    @Override
    public Pista crearPistaDeViaje(IPais pais) throws AlgoThiefException {
        throw new PistaException("No hay pistas fáciles para este tipo de edificio");
    }

    @Override
    public Pista crearPistaDeLadron(IRobo robo) {
        return new PistaDeLadron("Tenía un tatuaje");
    }
}
