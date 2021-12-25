package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDePaisesException;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Robo;

import java.util.ArrayList;

public class RoboMock extends Robo {
    public RoboMock() throws CantidadDePaisesException {
        super(new ArrayList<Pais>(), new ArrayList<Pais>(), null, null);
    }

    @Override
    public String reportarRobo(Object rango) {
        return null;
    }

    @Override
    public Pais lugarDeRobo()  {
        return new Pais("Chile", 0, 0);
    }

    @Override
    public String nombreDeArtefacto() {
        return null;
    }

    @Override
    public Ladron obtenerLadron() {
        return null;
    }

    @Override
    public Pais primerPais() {
        return null;
    }

    @Override
    public Pais paisDespuesDe(Pais paisDelTestigo) {
        return new Pais("PaisMock", 0, 0);
    }

}
