package edu.fiuba.algo3.modelo;

public class Detective extends Rango{
    double velocidadKmh;
    Dificultad dificultad;

    public Detective(){
        this.velocidadKmh = 1100;
        this.dificultad = new Facil();
    }
    @Override
    public double velocidadKmh() {
        return velocidadKmh;
    }

    @Override
    public Dificultad obtenerDificultadPistas(){
        return dificultad;
    }
}
