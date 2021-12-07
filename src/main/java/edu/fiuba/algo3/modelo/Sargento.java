package edu.fiuba.algo3.modelo;

public class Sargento implements IRango {
    double velocidadKmh;
    Dificultad dificultad;

    public Sargento(){
        this.velocidadKmh = 1500;
        this.dificultad = new Dificil();
    }
    @Override
    public double velocidadKmh() {
        return velocidadKmh;
    }

    @Override
    public Dificultad obtenerDificultadPistas(){
        return dificultad;
    }

    @Override
    public IRango subirRango(int cantidadDeArrestos) {
        return this;
    }
    @Override
    public Valor generarValorDeArtefacto() {
        return new MuyValioso();
    }

    @Override
    public void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador) {
        Viajar actividad = new Viajar(paisActual, paisDestino, this.velocidadKmh);
        actividad.reportar(temporizador);
    }
}
