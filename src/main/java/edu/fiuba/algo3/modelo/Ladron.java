package edu.fiuba.algo3.modelo;

import java.util.Arrays;

public class Ladron {

    private String nombre;
    private String genero;
    private String vehiculo;
    private String cabello;
    private String senia;
    private String hobby;

    public Ladron(String nombre, String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {

        this.nombre = nombre;
        this.genero = genero;
        this.vehiculo =  vehiculo;
        this.cabello = cabello;
        this.senia = senia;
        this.hobby = hobby;

    }

    public boolean coincideConPropiedades (String unGenero, String unVehiculo, String unCabello, String unaSenia, String unHobby){

        //TODO Encontrar forma de hacerlo sin if's

        boolean respuesta = false;

        if (this.genero.equals(unGenero) || unGenero.equals("")) {
            if(this.vehiculo.equals(unVehiculo) || unVehiculo.equals("")) {
                if(this.cabello.equals(unCabello) || unCabello.equals("")) {
                    if(this.senia.equals(unaSenia) || unaSenia.equals("")) {
                        if(this.hobby.equals(unHobby) || unHobby.equals("")) {
                            respuesta = true;
                        }
                    }
                }
            }
        }

        return respuesta;

    }

    public String nombre() {
        return nombre;
    }

    public String genero() {
        return genero;
    }

    public String vehiculo() {
        return vehiculo;
    }

    public String cabello() {
        return cabello;
    }

    public String senia() {
        return senia;
    }

    public String hobby() {
        return hobby;
    }
    
}
