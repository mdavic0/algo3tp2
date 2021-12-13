package edu.fiuba.algo3.modelo;

public interface IRobo {
    //TODO: implementar rango
    String reportarRobo(Object rango);

    IPais lugarDeRobo() throws Exception;

    String nombreDeArtefacto();

    Ladron obtenerLadron();

    IPais primerPais();

    IPais paisDespuesDe(IPais paisDelTestigo) throws Exception;
}
