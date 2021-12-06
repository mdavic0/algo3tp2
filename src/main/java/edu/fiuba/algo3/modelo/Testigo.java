package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class Testigo { 
    List<Pista> pistas;
    public Testigo(Pista... pistas){
        this.pistas = Arrays.asList(pistas);
    }
    public String cuestionar() {
        return pistas.get(0).contenido();
    }
}
