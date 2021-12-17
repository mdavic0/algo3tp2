package edu.fiuba.algo3.modelo;

public class Media implements IDificultad {

    //Las pistas para una Dificultad Media, daran en todos los casos una Pista de X tipo y en algunos casos una PistaDeLadron

    @Override
    public IPista crearPistaEconomica(IPais pais, Ladron ladron) {
        return new PistaCompuesta(pais.crearPistaEconomica(), ladron.crearPista());
    }

    @Override
    public IPista crearPistaHistorica(IPais pais, Ladron ladron) {
        return new PistaCompuesta(pais.crearPistaHistorica(), ladron.crearPista());
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais, Ladron ladron) {
        return pais.crearPistaDeViaje();
    }

}
