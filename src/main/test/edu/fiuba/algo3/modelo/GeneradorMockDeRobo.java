package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.interfaces.IGeneradorDeRobo;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Robo;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;

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
