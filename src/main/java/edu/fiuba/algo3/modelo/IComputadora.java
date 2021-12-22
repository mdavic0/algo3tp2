package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IComputadora {
    List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades);
}
