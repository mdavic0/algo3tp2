package edu.fiuba.algo3.modelo;

public interface IRobo {
    //TODO: implementar rango
    String reportarRobo(Object rango);

    Pais lugarDeRobo() throws Exception;

    String nombreDeArtefacto();

    Ladron obtenerLadron();

    Pais primerPais();

    Pais paisDespuesDe(IPais paisDelTestigo) throws Exception;
}
