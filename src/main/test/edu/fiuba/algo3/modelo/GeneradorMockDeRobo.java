package edu.fiuba.algo3.modelo;

import java.util.List;

public class GeneradorMockDeRobo implements IGeneradorDeRobo {

    @Override
    public Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones)
            throws Exception {
        
        return new Robo(
            paisesPosibles.subList(0, 3), 
            paisesPosibles, 
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));
    }

    
}
