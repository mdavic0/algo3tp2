package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.interfaces.ITemporizador;

public class ActividadMock {
    int duracion;

    public ActividadMock(int duracion){
        this.duracion = duracion;
    }

    public void reportar(ITemporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }

}
