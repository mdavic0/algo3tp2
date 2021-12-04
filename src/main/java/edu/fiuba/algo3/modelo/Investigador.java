package edu.fiuba.algo3.modelo;

public class Investigador implements IRango {
    double velocidadKmh;
    Dificultad dificultad;

    public Investigador(){
        this.velocidadKmh = 1300;
        this.dificultad = new Media();
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
    public IRango subirRango() {
        return new Sargento();
    }
}
