package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;


public class Computadora {

    Genero genero;
    String vehiculo;
    String cabello;
    String senia;
    String hobby;

    //String[] atributos;

    ArrayList<Ladron> ladrones;
    ArrayList<Ladron> posiblesLadrones;

    //OrdenDeArresto ordenDeArresto;

    public Computadora() throws Exception {
        ladrones = new ArrayList<Ladron>();
        ladrones.add( new Ladron("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Alonzo", "M", "Deportivo","Rubio", "Anillo","Tenis"));

    }

    public ArrayList<Ladron> consultarDatos( String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {

        posiblesLadrones = new ArrayList<Ladron>();

        if (genero.equals("F") || genero.equals("M")){this.genero = Genero.aPartirDe(genero);}

        this.vehiculo = vehiculo;
        this.cabello = cabello;
        this.senia = senia;
        this.hobby = hobby;

        for (int i = 0; i < ladrones.size(); i++) {
            if (genero.equals("") || this.genero.getClass().equals(ladrones.get(i).genero().getClass())) {
                if(this.vehiculo.equals(ladrones.get(i).vehiculo()) || this.vehiculo.equals("")) {
                    if(this.cabello.equals(ladrones.get(i).cabello()) || this.cabello.equals("")) {
                        if(this.senia.equals(ladrones.get(i).senia())|| this.senia.equals("")) {
                            if(this.hobby.equals(ladrones.get(i).hobby()) || this.hobby.equals("")) {
                                posiblesLadrones.add(ladrones.get(i));
                            }
                        }
                    }
                }
            }
        }

        return posiblesLadrones;

    }

}
