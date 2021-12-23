package edu.fiuba.algo3.modelo.robo;

import java.util.List;

import edu.fiuba.algo3.modelo.interfaces.IGeneradorDeRobo;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;

import java.util.Collections;

public class GeneradorDeRobo implements IGeneradorDeRobo {

    @Deprecated
    public Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones) throws Exception {
        Artefacto artefacto = rango.generarArtefacto(artefactos);
        List<IPais> via = artefacto.generarViaDeEscape(paisesPosibles, this);
        Ladron ladron = generarLadron(ladrones);
        return new Robo(via, paisesPosibles, ladron, artefacto);
    }

    private Ladron generarLadron(List<Ladron> ladrones) {
        Collections.shuffle(ladrones);
        return ladrones.get(0);
    }

    public List<IPais> generarViaDeEscape(List<IPais> paises, int cantidad) {
        Collections.shuffle(paises);
        return paises.subList(0, cantidad);
    }

    public Robo generarRobo(Policia policia, List<Artefacto> artefactos, List<IPais> paisesPosibles,
                            List<Ladron>ladrones) {
            Artefacto artefacto = policia.obtenerRango().generarArtefacto(artefactos);
            List<IPais> via = artefacto.generarViaDeEscape(paisesPosibles, this);
            Ladron ladron = generarLadron(ladrones);
            //TODO usar algothief exception
            try {
                return new Robo(via, paisesPosibles, ladron, artefacto);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }
}
