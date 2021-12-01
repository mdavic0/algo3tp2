package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class GeneradorDeEdificios {

    //TODO: generar distintos tipos de edificios
    List<Edificio> crearEdificiosPara(Pais pais){
        List<Edificio> edificios = new ArrayList<Edificio>();
        for(int i = 0; i < 3; i++){
            edificios.add(new Edificio("Edificio".concat(Integer.toString(i)), pais));
        }
        return edificios;
    }
}
