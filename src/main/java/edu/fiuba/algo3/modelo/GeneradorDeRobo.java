package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class GeneradorDeRobo implements IGeneradorDeRobo {
    List<PaisSinPistas> paises;
    List<Artefacto> artefactos;
    LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();

    public GeneradorDeRobo(List<PaisSinPistas> paises, List<Artefacto> artefactos) {
        this.paises = paises;
    }

    public GeneradorDeRobo() throws Exception {
        this.paises = lectorDeArchivo.obtenerPaises();
        this.artefactos = lectorDeArchivo.obtenerArtefactos();
    }

    @Override
    public List<PaisSinPistas> viaDePaises(Dificultad dificultad) {
        List<PaisSinPistas> via = new ArrayList<PaisSinPistas>(paises);
        Collections.shuffle(via);
        return via.subList(0, 7);
    }

    @Override
    public Artefacto artefacto(Dificultad dificultad) {
        return artefactos.get( (int) (Math.random() * artefactos.size()) );
    }

    @Override
    public Ladron generarLadron() throws Exception{
        return new Ladron("Roberta Rigoberta", "F", "Negro", "Cicatriz","Musica");
        
    }
}
