package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class EdificioDeViaje extends TipoDeEdificio {
    private Testigo testigo;

    public EdificioDeViaje(FabricaDePistas fabrica, IPais pais) throws Exception{
        this.testigo = new Testigo(fabrica.crearPistaEconomica(pais));
    }

    @Override
    public String obtenerTestimonio() {
        return testigo.cuestionar();
    }
}