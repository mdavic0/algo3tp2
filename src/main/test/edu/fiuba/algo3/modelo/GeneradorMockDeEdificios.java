package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class GeneradorMockDeEdificios implements IGeneradorDeEdificios {

    @Override
    public List<IEdificio> crearEdificiosPara(IPais pais, Dificultad dificultad) throws Exception {
        return new ArrayList<IEdificio>();
    }

    @Override
    public List<IEdificio> crearEdificiosPara(IPais pais) throws Exception {
        return new ArrayList<IEdificio>();
    }
    
}
