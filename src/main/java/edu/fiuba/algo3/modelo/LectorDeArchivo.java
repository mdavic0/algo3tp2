package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

//TODO: aun no lee paises. Estan hardcodeados
public class LectorDeArchivo {

    public List<PaisSinPistas> obtenerPaises() throws Exception {
        List<PaisSinPistas> paises = new ArrayList<>();
        for(int i = 0; i < 23; i++)
            paises.add( new PaisSinPistas("Francia"));
        return paises;
    }
    public List<Artefacto> obtenerArtefactos() {
        List<Artefacto> artefactos = new ArrayList<>();
        artefactos.add(new Artefacto("La torre eiffel"));
        artefactos.add(new Artefacto("La torre eiffel2"));
        artefactos.add(new Artefacto("La torre eiffel3"));
        artefactos.add(new Artefacto("La torre eiffel4"));
        artefactos.add(new Artefacto("La torre eiffel5"));
        artefactos.add(new Artefacto("La torre eiffel6"));
        artefactos.add(new Artefacto("La torre eiffel7"));
        artefactos.add(new Artefacto("La torre eiffel8"));
        artefactos.add(new Artefacto("La torre eiffel9"));
        artefactos.add(new Artefacto("La torre eiffel10"));
        artefactos.add(new Artefacto("La torre eiffel11"));
        artefactos.add(new Artefacto("La torre eiffel12"));
        return artefactos;
    }

}
