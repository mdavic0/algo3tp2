package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class EdificioEconomico extends TipoDeEdificio {

    List<Pista> pistasEconomicas = null;

    public EdificioEconomico(){
        pistasEconomicas = new ArrayList<Pista>();
        pistasEconomicas.add( new Pista ("pista economica 01", new PistaEconomica()));
    }

    public String seleccionarPista() {
        Pista pistaSeleccionada;
        pistaSeleccionada = pistasEconomicas.get(0); //cambiar a random
        return pistaSeleccionada.obtenerContenido();
    }

}
