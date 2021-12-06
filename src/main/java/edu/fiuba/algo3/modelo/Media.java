package edu.fiuba.algo3.modelo;

public class Media implements Dificultad {

    @Override
    public IPista crearPistaEconomica(IPais pais) {
        return new PistaDeMoneda(pais.moneda());
    }

    @Override
    public IPista crearPistaDeLectura(IPais pais) {
        return new PistaHistorica("Este país fue invadido por Inglaterra");
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais) throws Exception {
        throw new Exception("No hay pistas fáciles para este tipo de edificio");
    }

    @Override
    public IPista crearPistaDeLadron(IRobo robo) throws Exception {
        throw new Exception("No hay pistas fáciles para este tipo de edificio");
    }
}
