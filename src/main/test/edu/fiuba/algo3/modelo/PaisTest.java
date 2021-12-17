package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//mover tests en policia test sobre paises acá
public class PaisTest {

    @Test
    public void PaisCalculaDistanciaAOtroPais() throws Exception {
        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Argentina",  -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision
    }

    @Test
    public void conectarPaises() throws Exception {
        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); 
        Pais argentina = new Pais("Argentina",  -38.416097, -63.616672); 

        colombia.conectarA(argentina);
        assertTrue(colombia.sePuedeViajarA(argentina));
    }


    @Test
    public void paisSeCreaSinEdificios() throws Exception {
        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); 
        assertTrue(colombia.edificios().isEmpty());
    }
    @Test
    public void paisConNombre() throws Exception {
        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); 
        
        assertEquals(colombia.nombre(), "Colombia");
    }
}