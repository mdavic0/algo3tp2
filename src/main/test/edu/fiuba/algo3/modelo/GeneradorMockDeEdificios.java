package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GeneradorMockDeEdificios implements IGeneradorDeEdificios {
    List<IEdificio> edificios;

    public GeneradorMockDeEdificios(IEdificio ... edificios){
        this.edificios = Arrays.asList(edificios);
    }

    @Override
    public List<IEdificio> crearEdificiosPara(IPais pais, Dificultad dificultad) throws Exception {
        return this.edificios;
    }

    @Override
    public List<IEdificio> crearEdificiosPara(IPais pais) throws Exception {
        return this.edificios;
    }
    
}
