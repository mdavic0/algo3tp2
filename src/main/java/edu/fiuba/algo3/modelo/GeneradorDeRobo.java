package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class GeneradorDeRobo implements IGeneradorDeRobo {
    List<Pais> paises;
    List<Artefacto> artefactos;
    LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();

    public GeneradorDeRobo(List<Pais> paises, List<Artefacto> artefactos) {
        this.paises = paises;
    }

    public GeneradorDeRobo() throws Exception {
        this.paises = lectorDeArchivo.obtenerPaises();
        this.artefactos = lectorDeArchivo.obtenerArtefactos();
    }

    @Override
    public List<Pais> viaDePaises(Dificultad dificultad) {
        List<Pais> via = new ArrayList<Pais>(paises);
        Collections.shuffle(via);
        return paises.subList(0, 7);
    }

    @Override
    public Artefacto artefacto(Dificultad dificultad) {
        return artefactos.get( (int) (Math.random() * artefactos.size()) );
    }

    @Override
    public Ladron generarLadron() throws Exception{
        return new Ladron("Roberta Rigoberta", "F", "Negro", "Bien pero bien feo");
        
    }
}
