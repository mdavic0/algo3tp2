package edu.fiuba.algo3.modelo;

public class Novato extends Rango{
    double velocidadKmh;
    Dificultad dificultad;

    public Novato(){
        this.velocidadKmh = 900;
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
