package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class FabricaDePistas{ 
    IRobo robo;
    public FabricaDePistas(IRobo robo) {
        this.robo = robo;
    }

    private IPista crearPistaEconomica(IPais pais, Dificultad dificultad) throws Exception{
        return dificultad.crearPistaEconomica(pais);
    }

    private IPista crearPistaDeLectura(IPais pais, Dificultad dificultad)  throws Exception{
        return dificultad.crearPistaDeLectura(pais);
    }

    private IPista crearPistaDeViaje(IPais pais, Dificultad dificultad)  throws Exception{
        return dificultad.crearPistaDeViaje(pais);
    }

    public IPista crearPistaDeLadron(Dificultad dificultad) throws Exception{
        return dificultad.crearPistaDeLadron(robo);
    }

    public IPista crearPistaEconomica(IPais pais, IRango rango) throws Exception {
        return crearPistaEconomica(pais, rango.obtenerDificultadPistas());
    }

    public IPista crearPistaDeLectura(IPais pais, IRango rango) throws Exception{
        return crearPistaDeLectura(pais, rango.obtenerDificultadPistas());
    }

    public IPista crearPistaDeViaje(IPais pais, IRango rango) throws Exception {
        return crearPistaDeViaje(pais, rango.obtenerDificultadPistas());
    }
}
