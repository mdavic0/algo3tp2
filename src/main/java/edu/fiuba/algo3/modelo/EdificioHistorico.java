package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class EdificioHistorico implements ITipoDeEdificio {

    List<Pista> pistasDeLectura = null;

    public EdificioHistorico(){
        pistasDeLectura = new ArrayList<Pista>();
        pistasDeLectura.add( new Pista ("pista de lectura 01", new PistaDeViaje()));
    }

    public String seleccionarPista() {
        Pista pistaSeleccionada;
        pistaSeleccionada = pistasDeLectura.get(0); //cambiar a random para cuando tengamos las pistas
        return pistaSeleccionada.obtenerContenido();
    }

    @Override
    public Testigo crearTestigo(IRobo robo, IPais pais) {
        return new Testigo(robo, pais);
    }
}
