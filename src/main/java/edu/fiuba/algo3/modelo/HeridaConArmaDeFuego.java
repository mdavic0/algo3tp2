package edu.fiuba.algo3.modelo;

public class HeridaConArmaDeFuego implements IActividad {
    int duracion;
    public HeridaConArmaDeFuego() {
        this.duracion = 4; //4hs cada vez.
    }


    @Override
    public void reportar(ITemporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }
}
