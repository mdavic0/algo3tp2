package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;

import java.beans.PropertyChangeListener;

public class TemporizadorMock extends Temporizador {

    public TemporizadorMock() {
        super(0,0);
    }
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
