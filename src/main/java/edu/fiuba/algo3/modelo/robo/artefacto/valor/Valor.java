package edu.fiuba.algo3.modelo.robo.artefacto.valor;

import java.util.List;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.robo.GeneradorDeRobo;

public abstract class Valor {
    int cantidadPaises;

    public List<Pais> generarViaDeEscape(List<Pais> paisesPosibles, GeneradorDeRobo generadorDeRobo) {
        return generadorDeRobo.generarViaDeEscape(paisesPosibles, this.cantidadPaises);
    }
}
