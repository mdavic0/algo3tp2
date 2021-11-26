package edu.fiuba.algo3.modelo;
import java.util.List;

public class Robo {
    List<Pais> via;
    Artefacto artefacto;
    Ladron ladron;
    IGeneradorDeRobo generador = new GeneradorDeRobo();

    public Robo(Dificultad dificultad) throws Exception{
        via = generador.viaDePaises(dificultad);
        ladron = generador.generarLadron();
        artefacto = generador.artefacto(dificultad);
    } 
    public Robo(Dificultad dificultad, IGeneradorDeRobo generador) throws Exception {
        via = generador.viaDePaises(dificultad);
        ladron = generador.generarLadron();
        artefacto = generador.artefacto(dificultad);
    } 

    //TODO: implementar rango
    public String reportarRobo(Object rango) {
        return "Hola, ".concat(rango.toString()).concat(". Hubo un robo de ").concat(artefacto.toString());
    }
    public Pais lugarDeRobo() {
        return via.get(0);
    }
}

