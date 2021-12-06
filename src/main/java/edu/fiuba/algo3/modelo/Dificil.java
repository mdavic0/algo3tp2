package edu.fiuba.algo3.modelo;

public class Dificil implements Dificultad {

    @Override
    public Pista crearPistaEconomica(IPais pais) {
        return new PistaDeFuenteDeIngreso("el turismo");
    }

    @Override
    public Pista crearPistaDeLectura(IPais pais) {
        return new PistaHistorica("Pista dificil historica");
    }

    @Override
    public Pista crearPistaDeViaje(IPais pais) {
        return new PistaDeContinente("El continente");
    }

    @Override
    public Pista crearPistaDeLadron(IRobo robo) {
        // TODO Auto-generated method stub
        return new PistaDeLadron("Bien feo ese ladron");
    }
}
