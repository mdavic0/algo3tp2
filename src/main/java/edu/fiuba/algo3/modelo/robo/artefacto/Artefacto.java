package edu.fiuba.algo3.modelo.robo.artefacto;

import java.util.List;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.robo.GeneradorDeRobo;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Artefacto {
    String nombre;
    Valor valor;

    public Artefacto(String string, Valor valor) {
        this.nombre = string;
        this.valor = valor;
    }

    public String nombre(){
        return nombre;
    }

    public Valor valor() {
        return valor;
    }

    public List<Pais> generarViaDeEscape(List<Pais> paisesPosibles, GeneradorDeRobo generadorDeRobo) {
        return this.valor.generarViaDeEscape(paisesPosibles, generadorDeRobo);
    }
}
