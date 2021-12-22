package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


public class Computadora {

    ArrayList<Ladron> ladrones;

    public Computadora() {
        ladrones = new ArrayList<Ladron>();
        //TODO: CARGAR CON DATOS DEL JSON
        ladrones.add( new Ladron("Juan", "M", "Deportivo", "Negro", "Cicatriz","Música"));
        ladrones.add( new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Música"));
        ladrones.add( new Ladron("Alonzo", "M", "Deportivo","Rubio", "Anillo","Tenis"));
        ladrones.add(new Ladron("Carmen Sandiego", "F", "Moto", "Negro", "Tatuaje", "Tenis"));

    }

    List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades) {

        List<Ladron> ladronesSospechosos = new ArrayList<Ladron>();
        ladrones.stream().filter(ladron -> ladron.coincideConPropiedades(propiedades)).forEach(ladron -> ladronesSospechosos.add(ladron));

        if(ladronesSospechosos.size() == 1){
            policia.emitirOrdenDeArresto(new OrdenDeArresto(ladronesSospechosos.get(0)));
        }

        return ladronesSospechosos;
    }

}
