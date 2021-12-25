package edu.fiuba.algo3.modelo.robo;

import java.util.List;

import edu.fiuba.algo3.modelo.RangoMock;
import edu.fiuba.algo3.modelo.dificultad.Facil;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.rangos.Novato;
import edu.fiuba.algo3.modelo.robo.Robo;

import java.util.Arrays;

public class GeneradorMockDeEdificios extends GeneradorDeEdificios{
    List<Edificio> edificios;

    public GeneradorMockDeEdificios(Edificio ... edificios){
        super(new RangoMock(new Facil()));
        this.edificios = Arrays.asList(edificios);
    }

    @Override
    public void crearEdificiosPara(List<Pais> paises, Robo robo) {
        
    }
    
}
