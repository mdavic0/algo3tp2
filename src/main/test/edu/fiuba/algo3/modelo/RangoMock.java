package edu.fiuba.algo3.modelo;

public class RangoMock implements IRango{
    Valor valor;
    Dificultad dificultad = new Facil();

    public RangoMock(Valor valor) {
        this.valor = valor;
    }
    public RangoMock(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
    @Override
    public double velocidadKmh() {
        return 100;
    }
    @Override
    public Dificultad obtenerDificultadPistas() {
        return dificultad;
    }
    @Override
    public IRango subirRango() {
        return this;
    }
    @Override
    public Valor generarValorDeArtefacto() {
        return valor;
    }

    @Override
    public void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador) {
    }


}
