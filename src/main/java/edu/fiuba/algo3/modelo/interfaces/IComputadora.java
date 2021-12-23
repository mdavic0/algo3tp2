package edu.fiuba.algo3.modelo.interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.robo.Propiedad;

public interface IComputadora {
    List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades);
}
