package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Computadora;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;

public class ComputadoraMock extends Computadora {
    public ComputadoraMock() {
        super(new ArrayList<>());
    }
    @Override
    public List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades) {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

}
