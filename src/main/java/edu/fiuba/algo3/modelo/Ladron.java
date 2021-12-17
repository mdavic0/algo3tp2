package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.Collectors;

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

    public Pista crearPista() {
        SplittableRandom aleatorio = new SplittableRandom();
        int n = aleatorio.nextInt(1, 101); //crea numero entre 1 y 101
        String contenidoPista = "";

        //25% de probabilidad de que el contenido de la pista de ladron sea sobre alguna propiedad (Vehiculo, cabello, senia, hobby)
        if(n <= 25 ) contenidoPista = this.crearPistaDeVehiculo();
        if(n > 25 && n <= 50) contenidoPista = this.crearPistaDeCabello();
        if(n > 50 && n <= 75) contenidoPista = this.crearPistaDeSenia();
        if(n > 75) contenidoPista = this.crearPistaDeHobby();

        return new PistaDeLadron(contenidoPista);
    }

    private String crearPistaDeHobby() {
        return "Dijo que le gustaba ".concat(this.hobby);
    }

    private String crearPistaDeSenia() {
        return "Tenia un ".concat(this.senia);
    }

    private String crearPistaDeCabello() {
        return "Su cabello era".concat(this.cabello);
    }

    private String crearPistaDeVehiculo() {
        return "Llego conduciendo un ".concat(this.vehiculo);
    }
}
