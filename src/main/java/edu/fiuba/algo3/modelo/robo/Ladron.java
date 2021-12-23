package edu.fiuba.algo3.modelo.robo;

import edu.fiuba.algo3.modelo.pistas.*;

import java.util.*;

public class Ladron {

    private final String nombre;
    private final String vehiculo;
    private final String cabello;
    private final String senia;
    private final String hobby;

    private final List<Propiedad> propiedades= new ArrayList<Propiedad>();

    public Ladron(String nombre, String genero, String vehiculo, String cabello, String senia, String hobby)  {

        this.nombre = nombre;
        this.vehiculo =  vehiculo;
        this.cabello = cabello;
        this.senia = senia;
        this.hobby = hobby;

        Map<String, String> caracteristicas = new HashMap<>();

        caracteristicas.put("Genero", genero);
        caracteristicas.put("Vehiculo", vehiculo);
        caracteristicas.put("Cabello", cabello);
        caracteristicas.put("Senia", senia);
        caracteristicas.put("Hobby", hobby);

        caracteristicas.keySet().forEach(k -> {
            String[] subpropiedades= caracteristicas.get(k).split(";");
            for(String s : subpropiedades){
                propiedades.add(new Propiedad(k, s));
            }
        }
        );

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

        //25% de probabilidad de que el contenido de la pista de ladron sea sobre alguna propiedad (Vehiculo, cabello, senia, hobby)
        if(n <= 25 ) return new PistaDeVehiculo(this.vehiculo);
        if(n <= 50) return new PistaDeCabello(this.cabello);
        if( n <= 75) return new PistaDeSenia(this.senia);

        return new PistaDeHobby(this.hobby);
    }

}
