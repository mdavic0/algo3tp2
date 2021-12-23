package edu.fiuba.algo3.modelo.interfaces;
import java.util.List;

import edu.fiuba.algo3.modelo.robo.Robo;

public interface IGeneradorDeEdificios {
    void crearEdificiosPara(List<IPais> paises, Robo robo);
}
