package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;


public class Computadora {

    ArrayList<Ladron> ladrones;

    //OrdenDeArresto ordenDeArresto;

    public Computadora() throws Exception {
        ladrones = new ArrayList<Ladron>();
        ladrones.add( new Ladron("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Alonzo", "M", "Deportivo","Rubio", "Anillo","Tenis"));

    }

    public ArrayList<Ladron> consultarDatos( String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {

        ArrayList<Ladron> ladronesSospechosos = new ArrayList<Ladron>();
        ladrones.stream().filter(ladron -> ladron.coincideConPropiedades(genero, vehiculo, cabello, senia, hobby)).forEach(ladron -> ladronesSospechosos.add(ladron));

        return ladronesSospechosos;
    }

}
