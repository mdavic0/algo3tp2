package edu.fiuba.algo3.modelo.robo.artefacto.valor;

import java.util.Collections;
import java.util.List;
import edu.fiuba.algo3.modelo.interfaces.IPais;

public abstract class Valor {
    int cantidadPaises;

    public List<IPais> generarViaDeEscape(List<IPais> paisesPosibles) {
        Collections.shuffle(paisesPosibles);
        return paisesPosibles.subList(0, cantidadPaises);
    }
}
