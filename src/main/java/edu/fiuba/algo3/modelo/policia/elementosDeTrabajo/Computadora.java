package edu.fiuba.algo3.modelo.policia.elementosDeTrabajo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;
import edu.fiuba.algo3.modelo.policia.Policia;


public class Computadora {

    List<Ladron> ladrones;

    public Computadora(List<Ladron> ladrones) {
        this.ladrones = ladrones;

    }

    public List<Ladron> consultarDatos(Policia policia, List<Propiedad> propiedades) {

        List<Ladron> ladronesSospechosos = new ArrayList<Ladron>();
        ladrones.stream().filter(ladron -> ladron.coincideConPropiedades(propiedades)).forEach(ladron -> ladronesSospechosos.add(ladron));

        if(ladronesSospechosos.size() == 1){
            policia.emitirOrdenDeArresto(new OrdenDeArresto(ladronesSospechosos.get(0)));
        }

        return ladronesSospechosos;
    }

}
