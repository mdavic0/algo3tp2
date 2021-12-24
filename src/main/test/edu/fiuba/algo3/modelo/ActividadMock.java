package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;

public class ActividadMock {
    int duracion;

    public ActividadMock(int duracion){
        this.duracion = duracion;
    }

    public void reportar(Temporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }

}
