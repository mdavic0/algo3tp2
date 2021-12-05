package edu.fiuba.algo3.modelo;

public class Novato implements IRango {
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

    @Override
    public IRango subirRango() {
        return new Detective();
    }

    @Override
    public Valor generarValorDeArtefacto() {
        return new ValorMedio();
    }
}
