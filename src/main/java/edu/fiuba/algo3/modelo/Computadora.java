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
        ladrones.add(new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis"));

    }
 
    public List<Ladron> consultarDatos(Policia policia, String genero, String vehiculo, String cabello, String senia, String hobby) throws Exception {

        List<Ladron> ladronesSospechosos = new ArrayList<Ladron>();
        List<Propiedad> propiedades = new ArrayList<Propiedad>();

        //TODO unico lugar que liste todas las propiedades
        if(genero != "") propiedades.add(new Propiedad("Genero", genero));
        if(vehiculo != "") propiedades.add(new Propiedad("Vehiculo", vehiculo));
        if(cabello != "") propiedades.add(new Propiedad("Cabello", cabello));
        if(senia != "") propiedades.add(new Propiedad("Senia", senia));
        if(hobby != "") propiedades.add(new Propiedad("Hobby", hobby));
        ladrones.stream().filter(ladron -> ladron.coincideConPropiedades(propiedades)).forEach(ladron -> ladronesSospechosos.add(ladron));

        if(ladronesSospechosos.size() == 1){
            policia.emitirOrdenDeArresto(new OrdenDeArresto(ladronesSospechosos.get(0)));
        }

        return ladronesSospechosos;
    }

    public List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades) throws Exception {

        List<Ladron> ladronesSospechosos = new ArrayList<Ladron>();
        ladrones.stream().filter(ladron -> ladron.coincideConPropiedades(propiedades)).forEach(ladron -> ladronesSospechosos.add(ladron));

        if(ladronesSospechosos.size() == 1){
            policia.emitirOrdenDeArresto(new OrdenDeArresto(ladronesSospechosos.get(0)));
        }

        return ladronesSospechosos;
    }

}
