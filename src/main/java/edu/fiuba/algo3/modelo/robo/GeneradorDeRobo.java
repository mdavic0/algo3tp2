package edu.fiuba.algo3.modelo.robo;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.CantidadDePaisesException;
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
        Robo robo = new Robo(via, paisesPosibles, ladron, artefacto);
        GeneradorDeEdificios genEdificios = new GeneradorDeEdificios(robo, rango);
        genEdificios.crearEdificiosPara(paisesPosibles, robo);
        return robo;
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
                            List<Ladron>ladrones) throws CantidadDePaisesException {
        Artefacto artefacto = policia.generarArtefacto(artefactos);
        List<IPais> via = artefacto.generarViaDeEscape(paisesPosibles, this);
        Ladron ladron = generarLadron(ladrones);
        //TODO usar algothief exception
        Robo robo = new Robo(via, paisesPosibles, ladron, artefacto);
            
        GeneradorDeEdificios genEdificios = new GeneradorDeEdificios(robo, policia.obtenerRango());
        genEdificios.crearEdificiosPara(paisesPosibles, robo);

        return robo;
    }
}
