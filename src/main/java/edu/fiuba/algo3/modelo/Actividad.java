package edu.fiuba.algo3.modelo;

public abstract class Actividad {
    int duracion;

    public void reportar(ITemporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }
}
