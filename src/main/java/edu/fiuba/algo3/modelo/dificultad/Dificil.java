package edu.fiuba.algo3.modelo.dificultad;

import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IPista;
import edu.fiuba.algo3.modelo.pistas.PistaCompuesta;

public class Dificil implements IDificultad {
    //Las pistas para una Dificultad Dificil, daran en todos los casos una Pista de X tipo y en algunos casos una PistaDeLadron

    @Override
    public IPista crearPistaEconomica(IPais pais, Ladron ladron) {
        return pais.crearPistaEconomica();
    }

    @Override
    public IPista crearPistaHistorica(IPais pais, Ladron ladron) {
        return new PistaCompuesta(pais.crearPistaHistorica(), ladron.crearPista());
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais, Ladron ladron) {
        return pais.crearPistaDeViaje();
    }

}