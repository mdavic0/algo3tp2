package edu.fiuba.algo3.modelo;

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

        if ((this.genero.equals(unGenero) || unGenero.equals("")) &&
                (this.vehiculo.equals(unVehiculo) || unVehiculo.equals("")) &&
                (this.cabello.equals(unCabello) || unCabello.equals("")) &&
                (this.senia.equals(unaSenia) || unaSenia.equals("")) &&
                (this.hobby.equals(unHobby) || unHobby.equals(""))) {
                            respuesta = true;
        }

        return respuesta;

    }

    public String nombre() {
        return nombre;
    }
    
}
