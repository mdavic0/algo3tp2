package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class GeneradorMockDeRobo implements IGeneradorDeRobo {

    @Override
    public List<PaisSinPistas> viaDePaises(Dificultad dificultad) throws Exception {
        ArrayList<PaisSinPistas> list = new ArrayList<PaisSinPistas>();
        list.add(new PaisSinPistas("Zimbabwe"));
        list.add(new PaisSinPistas("Sokovia"));
        return list;
    }

    @Override
    public Artefacto artefacto(Dificultad dificultad) {
        return new Artefacto("Un artefacto Mock");
    }

    @Override
    public Ladron generarLadron() throws Exception{
        return new Ladron("Pablo","F", "Motocicleta", "Rubio", "Anillo", "Trepar montañas");
    }
    
}
