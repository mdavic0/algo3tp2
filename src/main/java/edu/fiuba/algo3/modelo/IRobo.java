package edu.fiuba.algo3.modelo;

public interface IRobo {
    //TODO: implementar rango
    String reportarRobo(Object rango);

    PaisSinPistas lugarDeRobo();

    String nombreDeArtefacto();

    Ladron obtenerLadron();

    PaisSinPistas primerPais();

    //TODO: generar distintos tipos de pistas
    Pista pistaParaPais(IPais pais);

    //TODO: generar distintos tipos de pistas
    Pista pistaParaPais(PaisSinPistas pais);

    //TODO: generar distintos tipos de pistas
    Pista pistaParaLadron();

    PaisSinPistas paisDespuesDe(PaisSinPistas pais);
}
