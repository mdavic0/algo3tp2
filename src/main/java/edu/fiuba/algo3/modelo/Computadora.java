package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


public class Computadora {

    ArrayList<Ladron> ladrones;

    public Computadora() throws Exception {
        ladrones = new ArrayList<Ladron>();
        //TODO: CARGAR CON DATOS DEL JSON
        ladrones.add( new Ladron("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Alonzo", "M", "Deportivo","Rubio", "Anillo","Tenis"));

    }

    public List<Ladron> consultarDatos(Policia policia, String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {

        List<Ladron> ladronesSospechosos = new ArrayList<Ladron>();
        ladrones.stream().filter(ladron -> ladron.coincideConPropiedades(genero, vehiculo, cabello, senia, hobby)).forEach(ladron -> ladronesSospechosos.add(ladron));

        if(ladronesSospechosos.size() == 1){
            policia.emitirOrdenDeArresto(new OrdenDeArresto(ladronesSospechosos.get(0)));
        }

        return ladronesSospechosos;
    }

}
