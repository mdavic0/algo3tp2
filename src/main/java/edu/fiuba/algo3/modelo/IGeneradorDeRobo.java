package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IGeneradorDeRobo {

    Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones)throws Exception;

}
