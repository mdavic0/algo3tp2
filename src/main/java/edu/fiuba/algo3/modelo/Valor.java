package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Valor {
    int cantidadPaises;

    public List<IPais> generarViaDeEscape(List<IPais> paisesPosibles, GeneradorDeRobo generadorDeRobo) {
        return generadorDeRobo.generarViaDeEscape(paisesPosibles, this.cantidadPaises);
    }
}
