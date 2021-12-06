package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class EdificioEconomico extends TipoDeEdificio {
    
    private Testigo testigo;

    public EdificioEconomico(FabricaDePistas fabrica, IPais pais) throws Exception{
        this.testigo = new Testigo(fabrica.crearPistaEconomica(pais.sinPistas()));
    }

    @Override
    public String obtenerTestimonio() {
        return testigo.cuestionar();
    }

}
