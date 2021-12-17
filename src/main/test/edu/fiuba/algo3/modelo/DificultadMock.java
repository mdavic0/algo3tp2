package edu.fiuba.algo3.modelo;

public class DificultadMock implements Dificultad {
    Valor v = new Comun();

    public DificultadMock() {}
    public DificultadMock(Valor v) {
        this.v = v;
    }
    public Valor generarValorDeArtefacto() {
        return v;
    }
    @Override
    public IPista crearPistaEconomica(IPais pais) {
        return new PistaMock("Pista!");
    }
    @Override
    public IPista crearPistaDeLectura(IPais pais) {
        return new PistaMock("Pista!");
    }
    @Override
    public IPista crearPistaDeViaje(IPais pais) {
        return new PistaMock("Pista!");
    }
    @Override
    public IPista crearPistaDeLadron(IRobo robo) {
        return new PistaMock("Pista!");
    }
}
