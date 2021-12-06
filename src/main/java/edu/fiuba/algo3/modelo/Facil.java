package edu.fiuba.algo3.modelo;

public class Facil implements Dificultad {

    @Override
    public Pista crearPistaEconomica(IPais pais) throws Exception{
        return new PistaDeMoneda(pais.moneda());
    }

    @Override
    public Pista crearPistaDeLectura(IPais pais) throws Exception{
        throw new Exception("No hay pistas fáciles para este tipo de edificio");
    }

    @Override
    public Pista crearPistaDeViaje(IPais pais) throws Exception {
        throw new Exception("No hay pistas fáciles para este tipo de edificio");
    }

    @Override
    public Pista crearPistaDeLadron(IRobo robo) throws Exception{
        throw new Exception("No hay pistas fáciles para este tipo de edificio");
    }
}
