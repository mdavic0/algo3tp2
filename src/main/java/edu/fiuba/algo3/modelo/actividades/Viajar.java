package edu.fiuba.algo3.modelo.actividades;

import edu.fiuba.algo3.modelo.pais.Pais;

public class Viajar extends Actividad {

    public Viajar(Pais paisOrigen, Pais paisDestino , double velocidadKmh){
        double distancia = calcularDistancia(paisOrigen, paisDestino);
        this.duracion = (int) (distancia / velocidadKmh);
    }

    private double calcularDistancia(Pais paisOrigen, Pais paisDestino) {
        return paisOrigen.distanciaA(paisDestino);
    }

}
