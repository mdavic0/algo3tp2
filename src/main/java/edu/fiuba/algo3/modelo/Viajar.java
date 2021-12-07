package edu.fiuba.algo3.modelo;

public class Viajar implements IActividad {
    int duracion;

    public Viajar(IPais paisOrigen, IPais paisDestino , double velocidadKmh){
        double distancia = calcularDistancia(paisOrigen, paisDestino);
        this.duracion = (int) (distancia / velocidadKmh);
    }

    private double calcularDistancia(IPais paisOrigen, IPais paisDestino) {
        return paisOrigen.distanciaA(paisDestino);
    }

    @Override
    public int duracion() {
        return duracion;
    }

    @Override
    public void reportar(ITemporizador temporizador) {
        temporizador.reportarActividad(this.duracion);
    }
}
