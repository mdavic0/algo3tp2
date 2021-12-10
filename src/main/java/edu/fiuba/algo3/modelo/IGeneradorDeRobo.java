package edu.fiuba.algo3.modelo;

public interface IGeneradorDeRobo {

    Robo generarRobo(Dificultad d, IRango rango, LectorDeArchivo lector) throws 
    Exception;

}
