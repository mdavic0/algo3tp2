package edu.fiuba.algo3.modelo;
import java.beans.PropertyChangeListener;

public  interface  ITemporizador {
    int horaActual();
    int horasTranscurridas();
    void reportarActividad(int duracion) ;
    void agregarSuscriptor(PropertyChangeListener suscriptor);
    String fechaActual();
}