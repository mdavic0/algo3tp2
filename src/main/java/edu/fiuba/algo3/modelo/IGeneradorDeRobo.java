package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IGeneradorDeRobo {

    Robo generarRobo(Dificultad d, IRango rango, LectorDeArchivo lector) throws 
    Exception;

}
