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

    public Computadora(){
        ladrones = new ArrayList<Ladron>();
        ladrones.add( new Ladron("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica"));
    }

    public ArrayList<Ladron> consultarDatos( String genero, String vehiculo, String cabello, String senia, String hobby){

        posiblesLadrones = new ArrayList<Ladron>();

        this.genero = Genero.aPartirDe(genero);
        this.vehiculo = vehiculo;
        this.cabello = cabello;
        this.senia = senia;
        this.hobby = hobby;

        for (int i = 0; i < ladrones.size(); i++) {
            if (this.genero == ladrones.get(i).genero() or (this.genero == ""))  {
                if(this.vehiculo.equals(ladrones.get(i).vehiculo())){
                    if(this.cabello.equals(ladrones.get(i).cabello())){
                        if(this.senia.equals(ladrones.get(i).senia())){
                            if(this.hobby.equals(ladrones.get(i).hobby())){
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
