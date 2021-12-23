package edu.fiuba.algo3.modelo.interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Propiedad;

public interface IComputadora {
    List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades);
}
