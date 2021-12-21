package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
    El estadoDeJuego se suscribe al inicio de una partida a todas las entidades que causan
    una victoria o pérdida del juego.
*/
public class EstadoDeJuego implements PropertyChangeListener { 
    public enum estadoJuego {
        EN_PROGRESO,
        GANADO,
        PERDIDO,
    }
    private estadoJuego estado = estadoJuego.EN_PROGRESO;
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "Arresto") {
            this.estado = estadoJuego.GANADO;
        }
        else if(evt.getPropertyName() == "FalloArresto") {
            this.estado = estadoJuego.PERDIDO;
        }
        else if(evt.getPropertyName() == "horasTranscurridas"){
            if((int)evt.getNewValue() > 154) {
                this.estado = estadoJuego.PERDIDO;
            }
        }
    }

    public boolean juegoEnProgreso(){
        return estado == estadoJuego.EN_PROGRESO;
    }

    public boolean juegoGanado(){
        return estado == estadoJuego.GANADO;
    }

    public boolean juegoPerdido(){
        return estado == estadoJuego.PERDIDO;
    }

    public String reportarAlUsuario() {
        if(estado == estadoJuego.GANADO)
            return "Felicitaciones! Ganaste!";
        if(estado == estadoJuego.PERDIDO)
            return "Perdiste che";
        return "Juego en progreso";
    }
}
