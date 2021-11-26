package edu.fiuba.algo3.modelo;

import java.util.Arrays;

public class Ladron {
    private Genero genero;
    private String vehiculo;
    private String cabello;
    private String[] atributos;

    public Genero genero() {
        return genero;
    }

    public String vehiculo() {
        return vehiculo;
    }

    public String cabello() {
        return cabello;
    }

    public Boolean tieneAtributos(String ... atributos) {
        return Arrays.asList(this.atributos).containsAll(Arrays.asList(atributos));
    }

    public Ladron(String genero, String vehiculo, String cabello, String ... atributosFisicos) throws Exception {
        this.genero = Genero.aPartirDe(genero);
        this.vehiculo =  vehiculo;
        this.cabello = cabello;
        this.atributos = atributosFisicos;
    }
    
}
