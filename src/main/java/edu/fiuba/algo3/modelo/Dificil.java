package edu.fiuba.algo3.modelo;

public class Dificil implements IDificultad {
    //Las pistas para una Dificultad Dificil, daran en todos los casos una Pista de X tipo y en algunos casos una PistaDeLadron

    @Override
    public IPista crearPistaEconomica(IPais pais, Ladron ladron) {
        return new PistaDeMoneda(pais.moneda());
    }

    @Override
    public IPista crearPistaHistorica(IPais pais, Ladron ladron) {
        return new PistaCompuesta(new PistaHistorica(pais.hechoHistorico()), ladron.crearPista());
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais, Ladron ladron) {
        return new PistaDeContinente(pais.continente());
    }
}
