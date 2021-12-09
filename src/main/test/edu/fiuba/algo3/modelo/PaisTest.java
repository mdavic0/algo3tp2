package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//mover tests en policia test sobre paises acá
public class PaisTest {

    @Test
    public void PaisCalculaDistanciaAOtroPais() throws Exception {
        Pais colombia = new Pais("Colombia", new GeneradorMockDeEdificios(), 4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia", new GeneradorMockDeEdificios(),  -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision
    }
}