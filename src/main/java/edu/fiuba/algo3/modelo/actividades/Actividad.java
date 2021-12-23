package edu.fiuba.algo3.modelo.actividades;

import edu.fiuba.algo3.modelo.interfaces.ITemporizador;

public abstract class Actividad {
    int duracion;

    public void reportar(ITemporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }
}
