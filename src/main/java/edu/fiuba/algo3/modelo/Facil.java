package edu.fiuba.algo3.modelo;

public class Facil implements IDificultad {

    //Las pistas para una Dificultad Facil, daran en todos los casos una Pista de X tipo y una PistaDeLadron

    @Override
    public IPista crearPistaEconomica(IPais pais, Ladron ladron) {
        return new PistaCompuesta(new PistaDeMoneda(pais.moneda()), ladron.crearPista());
    }

    @Override
    public IPista crearPistaHistorica(IPais pais, Ladron ladron) {
        return new PistaCompuesta(new PistaHistorica(pais.hechoHistorico()), ladron.crearPista());
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais, Ladron ladron) {
        return new PistaCompuesta(new PistaDeBandera(pais.coloresDeBandera()), ladron.crearPista());
    }

}
