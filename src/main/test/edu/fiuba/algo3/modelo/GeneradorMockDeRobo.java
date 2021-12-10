package edu.fiuba.algo3.modelo;

public class GeneradorMockDeRobo implements IGeneradorDeRobo {

    @Override
    public Robo generarRobo
        (Dificultad dificultad, IRango rango, LectorDeArchivo lector) 
            throws Exception {
        return new Robo(
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Anillo", "Tenis"),
            lector.obtenerArtefactos().get(0));
    }
    
}
