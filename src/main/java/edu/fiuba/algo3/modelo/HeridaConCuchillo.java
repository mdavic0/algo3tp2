package edu.fiuba.algo3.modelo;

public class HeridaConCuchillo extends Actividad {

    public HeridaConCuchillo(int vez) {
        this.duracion = vez <= 1 ? 2 : 1; //2hs la 1ra vez, 1hs las próximas veces
    }

}
