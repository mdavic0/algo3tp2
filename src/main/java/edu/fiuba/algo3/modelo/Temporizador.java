package edu.fiuba.algo3.modelo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Temporizador implements ITemporizador {
    List<PropertyChangeListener> suscriptores = new ArrayList<PropertyChangeListener>();
    int horasTranscurridas;
    int horaInicial;
    private String fecha;

    public Temporizador(int horaInicial) {
        this.horaInicial = horaInicial;
        this.horasTranscurridas = 0;
        this.fecha = DiccionarioDeDias.getById(0).dia().concat(", " + horaInicial + "hs");
    }


    @Override
    public int horaActual(){
        return (horaInicial + horasTranscurridas) % 24;
    }

    @Override
    public int horasTranscurridas(){
        return horasTranscurridas;
    }

    private void aumentarHoraActual(int aumento){
        int horaPrevia = horaActual();
        int tiempoTranscurridoPrevio = horasTranscurridas();

        horasTranscurridas += aumento;

        this.actualizarFecha();

        PropertyChangeEvent eventoTiempoTranscurrido = new PropertyChangeEvent(this, 
            "horasTranscurridas", 
            tiempoTranscurridoPrevio,
            horasTranscurridas());

        for(PropertyChangeListener suscriptor : suscriptores){
            suscriptor.propertyChange(eventoTiempoTranscurrido);
        }

        PropertyChangeEvent eventoHora = new PropertyChangeEvent(this, 
            "horaActual", 
            horaPrevia,
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

    public String fechaActual() {
        return this.fecha;
    }

    private void actualizarFecha() {
        int horasTotales = horaInicial + horasTranscurridas;
        int diaActual = (horasTotales / 24) > 6 ? ((horasTotales / 24) % 7) : (horasTotales / 24);
        this.fecha = DiccionarioDeDias.getById(diaActual).dia().concat(", " + horaActual() + "hs");
    }
}