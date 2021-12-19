package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;

public class TemporizadorMock implements ITemporizador{

    @Override
    public int horaActual() {
        return 0;
    }

    @Override
    public int horasTranscurridas() {
        return 0;
    }

    @Override
    public void reportarActividad(int duracion) {
        
    }

    @Override
    public void agregarSuscriptor(PropertyChangeListener suscriptor) {
        
    }

    @Override
    public String fechaActual() {
        return "9am";
    }

}
