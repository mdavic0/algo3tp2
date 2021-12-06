package edu.fiuba.algo3.modelo;

public interface IRobo {
    //TODO: implementar rango
    String reportarRobo(Object rango);

    PaisSinPistas lugarDeRobo() throws Exception;

    String nombreDeArtefacto();

    Ladron obtenerLadron();

    PaisSinPistas primerPais();

    PaisSinPistas paisDespuesDe(IPais paisDelTestigo);
}
