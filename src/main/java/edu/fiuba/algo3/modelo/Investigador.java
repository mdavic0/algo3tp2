package edu.fiuba.algo3.modelo;

public class Investigador extends Rango{
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
    public Rango subirRango() {
        return new Sargento();
    }
}
