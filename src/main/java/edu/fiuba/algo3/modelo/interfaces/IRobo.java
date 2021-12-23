package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.robo.Ladron;

public interface IRobo {
    //TODO: implementar rango
    String reportarRobo(Object rango);

    IPais lugarDeRobo() throws Exception;

    String nombreDeArtefacto();

    Ladron obtenerLadron();

    IPais primerPais();

    IPais paisDespuesDe(IPais paisDelTestigo) throws Exception;
}
