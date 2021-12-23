package edu.fiuba.algo3.modelo.interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.Artefacto;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Robo;

public interface IGeneradorDeRobo {

    Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones)throws Exception;

}
