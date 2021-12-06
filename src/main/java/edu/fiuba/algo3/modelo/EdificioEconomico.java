package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class EdificioEconomico extends TipoDeEdificio {
    
    private Pista pista;

    public EdificioEconomico(FabricaDePistas fabrica, IPais pais) throws Exception{
        pista = fabrica.crearPistaEconomica(pais);
    }

    @Override
    public String obtenerTestimonio() {
        return pista.contenido();
    }

}
