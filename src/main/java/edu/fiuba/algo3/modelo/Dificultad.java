package edu.fiuba.algo3.modelo;

public interface Dificultad {

    IPista crearPistaEconomica(IPais pais) throws Exception;

    IPista crearPistaDeLectura(IPais pais) throws Exception;

    IPista crearPistaDeViaje(IPais pais) throws Exception;

    IPista crearPistaDeLadron(IRobo robo) throws Exception;
}
