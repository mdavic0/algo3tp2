package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IGeneradorDeRobo {

    List<Pais> viaDePaises(Dificultad dificultad) throws Exception;

    Artefacto artefacto(Dificultad dificultad);

    Ladron generarLadron() throws Exception;

}
