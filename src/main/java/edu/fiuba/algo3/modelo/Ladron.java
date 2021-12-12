package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ladron {

    private String nombre;
    private String genero;
    private String vehiculo;
    private String cabello;
    private String senia;
    private String hobby;
    private List<Propiedad> propiedades= new ArrayList<Propiedad>();

    public Ladron(String nombre, String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {

        this.nombre = nombre;
        this.genero = genero;
        this.vehiculo =  vehiculo;
        this.cabello = cabello;
        this.senia = senia;
        this.hobby = hobby;

        //TODO unico lugar que liste todas las propiedades
        propiedades.add(new Propiedad("Genero", genero));
        propiedades.add(new Propiedad("Vehiculo", vehiculo));
        propiedades.add(new Propiedad("Cabello", cabello));
        propiedades.add(new Propiedad("Senia", senia));
        propiedades.add(new Propiedad("Hobby", hobby));

    }
    
    public boolean coincideConPropiedades (List<Propiedad> propiedades){
        return propiedades.stream().allMatch(p -> this.coincideConPropiedad(p));
    }

    private boolean coincideConPropiedad(Propiedad propiedad_conocida){
        return this.propiedades
            .stream()
            .filter(p -> propiedad_conocida.coincidencia(p))
            .count() > 0;
    }


    public String nombre() {
        return nombre;
    }
    
}
