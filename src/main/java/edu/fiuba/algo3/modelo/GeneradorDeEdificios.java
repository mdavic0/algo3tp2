package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class GeneradorDeEdificios {
    IRobo robo;
    public GeneradorDeEdificios(IRobo robo) {
        this.robo = robo;
    }

    //TODO: generar distintos tipos de edificios
    List<IEdificio> crearEdificiosPara(IPais pais) throws Exception{
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        for(int i = 0; i < 3; i++){
            String nombre = "Edificio".concat(Integer.toString(i));
            edificios.add(new Edificio(nombre, pais, robo, new EdificioEconomico()));
        }
        return edificios;
    }
}
