package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.robo.Ladron;

public interface IDificultad {

    Pista crearPistaEconomica(Pais pais, Ladron ladron);

    Pista crearPistaHistorica(Pais pais, Ladron ladron);

    Pista crearPistaDeViaje(Pais pais, Ladron ladron);

}
