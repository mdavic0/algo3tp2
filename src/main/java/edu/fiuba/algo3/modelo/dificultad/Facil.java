package edu.fiuba.algo3.modelo.dificultad;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.pistas.PistaCompuesta;

public class Facil implements IDificultad {

    //Las pistas para una Dificultad Facil, daran en todos los casos una Pista de X tipo y una PistaDeLadron

    @Override
    public Pista crearPistaEconomica(Pais pais, Ladron ladron) {
        return new PistaCompuesta(pais.crearPistaEconomica(), ladron.crearPista());
    }

    @Override
    public Pista crearPistaHistorica(Pais pais, Ladron ladron) {
        return new PistaCompuesta(pais.crearPistaHistorica(), ladron.crearPista());
    }

    @Override
    public Pista crearPistaDeViaje(Pais pais, Ladron ladron) {
        return new PistaCompuesta(pais.crearPistaDeViaje(), ladron.crearPista());
    }

}
