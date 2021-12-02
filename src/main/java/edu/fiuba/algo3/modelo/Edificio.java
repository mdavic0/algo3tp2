package edu.fiuba.algo3.modelo;

public class Edificio {
    Pais pais;
    Robo robo;
    Testigo testigo;
    String nombre;

    public Edificio(String nombre, Pais pais, Robo robo){
        this.pais = pais;
        this.nombre = nombre;
        this.robo = robo;
        this.testigo = new Testigo(robo, pais);
    }
    
    public Testigo obtenerTestigo() {
        return this.testigo;
    }

    public Pais obtenerPais() {
        return this.pais;
    }
}
