package edu.fiuba.algo3.modelo;

public class Dificil implements Dificultad {

    @Override
    public Valor generarValorDeArtefacto() {
        return new MuyValioso();
    }
}
