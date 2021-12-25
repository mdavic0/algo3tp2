package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.RangoMock;
import edu.fiuba.algo3.modelo.pais.lugarActual.Inactivo;
import edu.fiuba.algo3.modelo.policia.rangos.Rango;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;

public class PoliciaMock extends Policia {
    public PoliciaMock(){
        lugarActual = new Inactivo();
        rango = new RangoMock( new Comun());
        ordenDeArresto = null;
        cantidadArrestos = 0;
    }
    public PoliciaMock(Rango rango){
        lugarActual = new Inactivo();
        this.rango = rango;
        ordenDeArresto = null;
        cantidadArrestos = 0;
    }
}
