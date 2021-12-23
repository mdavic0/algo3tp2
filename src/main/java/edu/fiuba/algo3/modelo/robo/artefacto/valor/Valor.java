package edu.fiuba.algo3.modelo.robo.artefacto.valor;

import java.util.List;

import edu.fiuba.algo3.modelo.robo.GeneradorDeRobo;
import edu.fiuba.algo3.modelo.interfaces.IPais;

public abstract class Valor {
    int cantidadPaises;

    public List<IPais> generarViaDeEscape(List<IPais> paisesPosibles, GeneradorDeRobo generadorDeRobo) {
        return generadorDeRobo.generarViaDeEscape(paisesPosibles, this.cantidadPaises);
    }
}