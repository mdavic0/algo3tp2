package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class EdificioDeLectura extends TipoDeEdificio {

    List<Pista> pistasDeLectura = null;

    public EdificioDeLectura(){
        pistasDeLectura = new ArrayList<Pista>();
        pistasDeLectura.add( new Pista ("pista de lectura 01", new PistaDeViaje()));
    }

    public String seleccionarPista() {
        Pista pistaSeleccionada;
        pistaSeleccionada = pistasDeLectura.get(0); //cambiar a random para cuando tengamos las pistas
        return pistaSeleccionada.obtenerContenido();
    }
}
