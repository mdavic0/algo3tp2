package edu.fiuba.algo3.modelo;

public class Dormir implements IActividad {
    int duracion;
    public Dormir() {
        this.duracion = 8; // 8hs por noche.
    }

    @Override
    public int duracion() {
        return duracion;
    }
}
