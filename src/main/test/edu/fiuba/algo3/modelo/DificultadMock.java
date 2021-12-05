package edu.fiuba.algo3.modelo;

public class DificultadMock implements Dificultad {
    Valor v = new ValorMedio();

    public DificultadMock() {}
    public DificultadMock(Valor v) {
        this.v = v;
    }
    public Valor generarValorDeArtefacto() {
        return v;
    }
}
