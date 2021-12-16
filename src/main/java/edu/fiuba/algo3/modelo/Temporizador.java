package edu.fiuba.algo3.modelo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Temporizador implements ITemporizador {
    List<PropertyChangeListener> suscriptores = new ArrayList<PropertyChangeListener>();
    int horas_transcurridas;
    int hora_inicial;

    Temporizador(int hora_inicial) {
        this.hora_inicial = hora_inicial;
        horas_transcurridas = 0;
    }

    @Override
    public int horaActual(){
        return (hora_inicial + horas_transcurridas) % 24;
    }

    @Override
    public int horasTranscurridas(){
        return horas_transcurridas;
    }

    private void aumentarHoraActual(int hora_a_agregar){
        int hora_previa = horaActual();
        int tiempo_transcurrido_previo = horasTranscurridas();

        horas_transcurridas +=hora_a_agregar;

        PropertyChangeEvent eventoTiempoTranscurrido = new PropertyChangeEvent(this, 
            "horasTranscurridas", 
            tiempo_transcurrido_previo,
            horasTranscurridas());

        for(PropertyChangeListener suscriptor : suscriptores){
            suscriptor.propertyChange(eventoTiempoTranscurrido);
        }

        PropertyChangeEvent eventoHora = new PropertyChangeEvent(this, 
            "horaActual", 
            hora_previa, 
            horaActual());
          
        for(PropertyChangeListener suscriptor : suscriptores){
            suscriptor.propertyChange(eventoHora);
        }
    }

    @Override
    public void reportarActividad(int duracion) {
        aumentarHoraActual(duracion);
    }

    @Override
    public void agregarSuscriptor(PropertyChangeListener suscriptor){
        suscriptores.add(suscriptor);
    }
}