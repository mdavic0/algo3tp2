package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class FabricaDePistas{ 
    IRobo robo;
    public FabricaDePistas(IRobo robo) {
        this.robo = robo;
    }

    public Pista crearPistaEconomica(PaisSinPistas pais){
        return new PistaEconomica("Quería cambiar su dinero por"); // + pais.moneda()
    }

    public Pista crearPistaDeLadron(){
        return new Pista("Pista de ladrón");
    }
}
