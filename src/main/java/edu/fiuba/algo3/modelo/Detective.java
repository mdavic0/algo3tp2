package edu.fiuba.algo3.modelo;

public class Detective implements IRango {
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

    @Override
    public IRango subirRango() {
        return new Investigador();
    }
    @Override
    public Valor generarValorDeArtefacto() {
        return new Valioso();
    }
}
