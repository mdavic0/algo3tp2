package edu.fiuba.algo3.modelo;

public  interface  ITemporizador {
    int horaActual();
    int horasTranscurridas();
    void reportarActividad(IActividad IActividad) ;
}