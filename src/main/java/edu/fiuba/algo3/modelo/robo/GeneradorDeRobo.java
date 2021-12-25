package edu.fiuba.algo3.modelo.robo;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.CantidadDePaisesException;
import edu.fiuba.algo3.modelo.interfaces.IGeneradorDeEdificios;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;

import java.util.Collections;

public class GeneradorDeRobo {

    private Ladron generarLadron(List<Ladron> ladrones) {
        Collections.shuffle(ladrones);
        return ladrones.get(0);
    }

    public Robo generarRobo(Policia policia, List<Artefacto> artefactos, List<IPais> paisesPosibles,
                            List<Ladron>ladrones) throws CantidadDePaisesException {
        return generarRobo(policia.obtenerRango(), 
            artefactos, paisesPosibles, ladrones, new GeneradorDeEdificios(policia.obtenerRango()));     
    }

    public Robo generarRobo(Policia policia, List<Artefacto> artefactos, List<IPais> paisesPosibles,
                            List<Ladron>ladrones, IGeneradorDeEdificios generador) throws CantidadDePaisesException {
        return generarRobo(policia.obtenerRango(), 
            artefactos, paisesPosibles, ladrones, generador);     
    }

    public Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones,
            IGeneradorDeEdificios generador) throws CantidadDePaisesException {
        Artefacto artefacto = rango.generarArtefacto(artefactos);
        List<IPais> via = artefacto.generarViaDeEscape(paisesPosibles);
        Ladron ladron = generarLadron(ladrones);
        Robo robo = new Robo(via, paisesPosibles, ladron, artefacto);
            
        generador.crearEdificiosPara(paisesPosibles, robo);
        return robo;
    }
}
