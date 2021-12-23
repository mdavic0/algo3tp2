package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.robo.Ladron;

public interface IDificultad {

    IPista crearPistaEconomica(IPais pais, Ladron ladron);

    IPista crearPistaHistorica(IPais pais, Ladron ladron);

    IPista crearPistaDeViaje(IPais pais, Ladron ladron);

}
