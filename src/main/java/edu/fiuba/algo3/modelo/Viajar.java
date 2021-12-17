package edu.fiuba.algo3.modelo;

public class Viajar extends Actividad {

    public Viajar(IPais paisOrigen, IPais paisDestino , double velocidadKmh){
        double distancia = calcularDistancia(paisOrigen, paisDestino);
        this.duracion = (int) (distancia / velocidadKmh);
    }

    private double calcularDistancia(IPais paisOrigen, IPais paisDestino) {
        return paisOrigen.distanciaA(paisDestino);
    }

}
