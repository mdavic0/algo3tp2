package edu.fiuba.algo3.modelo;

public class EmitirOrdenDeArresto implements IActividad {
    int duracion;

    public EmitirOrdenDeArresto() {
        this.duracion = 3; //3hs cada vez
    }

    @Override
    public int duracion() {
        return duracion;
    }

    @Override
    public void reportar(ITemporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }
}
