package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class EdificioDeViaje extends TipoDeEdificio {

    List<Pista> pistasDeViaje = null;

    public EdificioDeViaje(){
        pistasDeViaje = new ArrayList<Pista>();
        pistasDeViaje.add( new Pista ("pista de viaje 01", new PistaDeViaje()));
    }

    public String seleccionarPista() {
        Pista pistaSeleccionada;
        pistaSeleccionada = pistasDeViaje.get(0); //cambiar a random para cuando tengamos las pistas
        return pistaSeleccionada.obtenerContenido();
    }
}
