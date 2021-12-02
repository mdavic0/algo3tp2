package edu.fiuba.algo3.modelo;

public class Sargento extends Rango{
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
    public Rango subirRango() {
        return this;
    }
}
