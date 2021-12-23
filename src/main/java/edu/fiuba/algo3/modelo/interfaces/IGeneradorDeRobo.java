package edu.fiuba.algo3.modelo.interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Robo;

public interface IGeneradorDeRobo {

    Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones)throws Exception;

}
