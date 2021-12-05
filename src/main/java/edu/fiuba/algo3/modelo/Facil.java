package edu.fiuba.algo3.modelo;

public class Facil implements Dificultad {

    @Override
    public Valor generarValorDeArtefacto() {
        return new ValorMedio();
    }
}
