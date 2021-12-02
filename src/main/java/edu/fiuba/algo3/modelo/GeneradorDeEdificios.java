package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class GeneradorDeEdificios {
    Robo robo;
    public GeneradorDeEdificios(Robo robo) {
        this.robo = robo;
    }

    //TODO: generar distintos tipos de edificios
    List<Edificio> crearEdificiosPara(Pais pais) throws Exception{
        List<Edificio> edificios = new ArrayList<Edificio>();
        for(int i = 0; i < 3; i++){
            String nombre = "Edificio".concat(Integer.toString(i));
            edificios.add(new Edificio(nombre, pais, robo));
        }
        return edificios;
    }
}
