package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.policia.rangos.Detective;
import edu.fiuba.algo3.modelo.policia.rangos.Investigador;
import edu.fiuba.algo3.modelo.policia.rangos.Novato;
import edu.fiuba.algo3.modelo.policia.rangos.Sargento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RangoTest {
    @Test
    public void NovatoReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        Novato rango = new Novato();

        Pais colombia = new Pais("Colombia",   4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0,20);

        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/900.0, temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

    @Test
    public void DetectiveReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        Detective rango = new Detective();

        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0, 20);

        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/1100.0, temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

    @Test
    public void InvestigadorReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        Investigador rango = new Investigador();

        Pais colombia = new Pais("Colombia",   4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0,20);

        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/1300.0, temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

    @Test
    public void SargentoReportaUnViajeCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPaisSuVelocidadKmh() throws Exception {
        Sargento rango = new Sargento();

        Pais colombia = new Pais("Colombia",   4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia",    -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0,20);
        rango.reportarViaje(colombia, argentina, temporizador);

        assertEquals(distanciaEsperada/1500.0 , temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs

    }

}
