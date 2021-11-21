package edu.fiuba.algo3.modelo;

public class Edificio {
    // Pais unPais
    Testigo testigo = new Testigo();
    String nombre;

    public Edificio(String nombre){
        this.nombre = nombre;
    }
    
    public Testigo obtenerTestigo() {
        return this.testigo;
    }

}
