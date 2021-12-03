package edu.fiuba.algo3.modelo;

public class Viajar implements IActividad {
    int duracion;

    public Viajar(Pais paisOrigen, Pais paisDestino , double velocidadKmh){
        int distancia = calcularDistancia(paisOrigen, paisDestino);
        this.duracion = (int) (distancia / velocidadKmh);
    }

    private int calcularDistancia(Pais paisOrigen, Pais paisDestino) {
        return paisOrigen.distanciaA(paisDestino);
    }

    @Override
    public int duracion() {
        return duracion;
    }
}
