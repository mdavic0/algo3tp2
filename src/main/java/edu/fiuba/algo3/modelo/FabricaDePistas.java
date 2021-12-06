package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class FabricaDePistas{ 
    IRobo robo;
    public FabricaDePistas(IRobo robo) {
        this.robo = robo;
    }

    public Pista crearPistaEconomica(IPais pais, Dificultad dificultad) throws Exception{
        return new PistaDeMoneda(robo.paisDespuesDe(pais).moneda());
    }

    public Pista crearPistaDeLectura(IPais pais, Dificultad dificultad)  throws Exception{
        return new PistaDeMoneda(robo.paisDespuesDe(pais).moneda());
    }

    public Pista crearPistaDeViaje(IPais pais, Dificultad dificultad)  throws Exception{
        return new PistaDeMoneda(robo.paisDespuesDe(pais).moneda());
    }

    public Pista crearPistaDeLadron(Dificultad dificultad){
        return new PistaDeLadron("Pista de ladrón");
    }
}
