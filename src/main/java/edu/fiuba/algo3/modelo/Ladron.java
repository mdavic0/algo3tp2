package edu.fiuba.algo3.modelo;

import java.util.Arrays;

public class Ladron {
    private String nombre;
    private Genero genero;
    private String vehiculo;
    private String cabello;
    private String senia;
    private String hobby;
    //private String[] atributos;
    
    public String nombre() {
        return nombre;
    }

    public Genero genero() { return genero; }

    public String vehiculo() {
        return vehiculo;
    }

    public String cabello() {
        return cabello;
    }

    public String senia() {
        return cabello;
    }

    public String hobby() {
        return cabello;
    }

    /*public Boolean tieneAtributos(String ... atributos) {
        return Arrays.asList(this.atributos).containsAll(Arrays.asList(atributos));
    }*/

    public Ladron(String nombre, String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {
        this.nombre = nombre;
        this.genero = Genero.aPartirDe(genero);
        this.vehiculo =  vehiculo;
        this.cabello = cabello;
        this.senia = senia;
        this.hobby = hobby;

    }
    
}
