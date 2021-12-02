package edu.fiuba.algo3.modelo;

public class Testigo { 
    Pista pista;
    public Testigo(Robo robo, Pais pais){
        pista = robo.pistaParaPais(pais);
    }
    public String cuestionar() {
        return pista.contenido();
    }
}
