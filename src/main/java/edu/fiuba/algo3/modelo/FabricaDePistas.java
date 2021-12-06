package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class FabricaDePistas{ 
    IRobo robo;
    public FabricaDePistas(IRobo robo) {
        this.robo = robo;
    }

    public Pista crearPistaEconomica(IPais pais) throws Exception{
        return new PistaDeMoneda(robo.paisDespuesDe(pais).moneda());
    }

    public Pista crearPistaDeLadron(){
        return new PistaDeLadron("Pista de ladrón");
    }
}
