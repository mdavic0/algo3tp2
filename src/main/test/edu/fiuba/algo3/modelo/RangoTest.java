package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RangoTest {
    @Test
    public void NovatoReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        IRango rango = new Novato();

        Pais colombia = new Pais("Colombia",   4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0,20);

        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/rango.velocidadKmh(), temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

    @Test
    public void DetectiveReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        IRango rango = new Detective();

        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0, 20);

        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/rango.velocidadKmh(), temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

    @Test
    public void InvestigadorReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        IRango rango = new Investigador();

        Pais colombia = new Pais("Colombia",   4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0,20);

        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/rango.velocidadKmh(), temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

    @Test
    public void SargentoReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        IRango rango = new Sargento();

        Pais colombia = new Pais("Colombia",   4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0,20);
        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/rango.velocidadKmh(), temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

}
