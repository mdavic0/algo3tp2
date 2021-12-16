package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AlgoThiefException;
import edu.fiuba.algo3.modelo.excepciones.PistaException;

public class Media implements Dificultad {

    @Override
    public IPista crearPistaEconomica(IPais pais) {
        return new PistaDeMoneda(pais.moneda());
    }

    @Override
    public IPista crearPistaDeLectura(IPais pais) {
        return new PistaHistorica("Este país fue invadido por Inglaterra");
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais) throws AlgoThiefException {
        throw new PistaException("No hay pistas fáciles para este tipo de edificio");
    }

    @Override
    public IPista crearPistaDeLadron(IRobo robo) throws AlgoThiefException {
        throw new PistaException("No hay pistas fáciles para este tipo de edificio");
    }
}
