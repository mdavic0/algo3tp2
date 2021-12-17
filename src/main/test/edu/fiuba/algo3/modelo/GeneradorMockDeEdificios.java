package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Arrays;

public class GeneradorMockDeEdificios implements IGeneradorDeEdificios {
    List<IEdificio> edificios;

    public GeneradorMockDeEdificios(IEdificio ... edificios){
        this.edificios = Arrays.asList(edificios);
    }

    @Override
    public void crearEdificiosPara(List<IPais> paises, Robo robo, IDificultad d) throws Exception {
        
    }
    
}
