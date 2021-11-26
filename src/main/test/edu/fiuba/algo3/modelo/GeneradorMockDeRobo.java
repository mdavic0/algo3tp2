package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class GeneradorMockDeRobo implements IGeneradorDeRobo {

    @Override
    public List<Pais> viaDePaises(Dificultad dificultad) {
        ArrayList<Pais> list = new ArrayList<Pais>();
        list.add(new Pais("Zimbabwe"));
        list.add(new Pais("Sokovia"));
        return list;
    }

    @Override
    public Artefacto artefacto(Dificultad dificultad) {
        return new Artefacto("Un artefacto Mock");
    }

    @Override
    public Ladron generarLadron() throws Exception{
        return new Ladron("F", "Motocicleta", "Rubio", "Feo", "Anillo", "Tatuaje en el brazo", "Trepar montañas");
        
    }
    
}
