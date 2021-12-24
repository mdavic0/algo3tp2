package edu.fiuba.algo3.modelo.actividades;

import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;

public abstract class Actividad {
    int duracion;

    public void reportar(Temporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }
}
