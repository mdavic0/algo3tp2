package edu.fiuba.algo3.modelo;

public class Edificio {
    Pais pais;
    Testigo testigo = new Testigo();
    String nombre;

    public Edificio(String nombre, Pais pais){
        this.pais = pais;
        this.nombre = nombre;
    }
    
    public Testigo obtenerTestigo() {
        return this.testigo;
    }

    public Pais obtenerPais() {
        return this.pais;
    }
}
