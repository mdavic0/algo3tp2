package edu.fiuba.algo3.modelo;

public class Viajar implements IActividad {
    int duracion;

    public Viajar(IPais paisOrigen, IPais paisDestino , double velocidadKmh){
        int distancia = calcularDistancia(paisOrigen, paisDestino);
        this.duracion = (int) (distancia / velocidadKmh);
    }

    private int calcularDistancia(IPais paisOrigen, IPais paisDestino) {
        return paisOrigen.distanciaA(paisDestino);
    }

    @Override
    public int duracion() {
        return duracion;
    }
}
