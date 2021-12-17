package edu.fiuba.algo3.modelo;

public class EntrarAEdificio extends Actividad {

    public EntrarAEdificio(int vez){
        this.duracion = Math.min(vez, 3); //1h la primera vez, 2hs la segunda vez, 3hs por tercera vez. y luego siempre 3
    }

}
