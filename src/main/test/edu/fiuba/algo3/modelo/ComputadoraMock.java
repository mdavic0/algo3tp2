package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.interfaces.IComputadora;

public class ComputadoraMock implements IComputadora {

    @Override
    public List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades) {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

}
