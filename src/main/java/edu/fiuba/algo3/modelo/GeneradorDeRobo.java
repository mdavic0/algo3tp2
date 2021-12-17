package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class GeneradorDeRobo implements IGeneradorDeRobo {

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
}
