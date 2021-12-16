package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActividadTest {

    @Test
    public void DormirCausaUnIncrementoHorarioDe8hs() throws Exception {
        Temporizador temporizador = new Temporizador(0);
         IActividad actividad = new Dormir();

         actividad.reportar(temporizador);

         assertEquals(8, temporizador.horasTranscurridas());
     }

     @Test
     public void EmitirOrdenDeArrestoCausaUnIncrementoHorarioDe3hs() throws Exception {
         Temporizador temporizador = new Temporizador(0);
         IActividad actividad = new EmitirOrdenDeArresto();

         actividad.reportar(temporizador);

         assertEquals(3, temporizador.horasTranscurridas());
    }

    @Test
    public void EntrarAEdificioCausaUnIncrementoHorarioDe1hLaPrimeraVez2hsLaSegundaYLuegoSiempre3hs() throws Exception {
        Temporizador temporizador = new Temporizador(0);

        IActividad actividad = new EntrarAEdificio(1);
        actividad.reportar(temporizador);
        assertEquals(1, temporizador.horasTranscurridas());

        IActividad actividad2 = new EntrarAEdificio(2);
        actividad2.reportar(temporizador);
        assertEquals(1 + 2, temporizador.horasTranscurridas());

        IActividad actividad3 = new EntrarAEdificio(3);
        actividad3.reportar(temporizador);
        assertEquals(1 + 2 + 3, temporizador.horasTranscurridas());

    }

    @Test
    public void HeridaConArmaDeFuegoCausaUnIncrementoHorarioDe4hs() throws Exception {
        Temporizador temporizador = new Temporizador(0);
        IActividad actividad = new HeridaConArmaDeFuego();

        actividad.reportar(temporizador);

        assertEquals(4, temporizador.horasTranscurridas());
    }

    @Test
    public void HeridaConCuchilloCausaUnIncrementoHorarioDe2hsLaPrimeraVezY1hsLasProximasVeces() throws Exception {
        Temporizador temporizador = new Temporizador(0);

        IActividad actividad = new HeridaConCuchillo(1);
        actividad.reportar(temporizador);
        assertEquals(2, temporizador.horasTranscurridas());

        IActividad actividad2 = new HeridaConCuchillo(2);
        actividad2.reportar(temporizador);
        assertEquals(2 + 1, temporizador.horasTranscurridas());

        IActividad actividad3 = new HeridaConCuchillo(3);
        actividad3.reportar(temporizador);
        assertEquals(2 + 1 + 1, temporizador.horasTranscurridas());
    }

    @Test
    public void ViajarCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPais() throws Exception {
        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Colombia", -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0);
        double velocidadKmh = 1000.0;
        IActividad actividad = new Viajar(colombia, argentina, velocidadKmh);
        actividad.reportar(temporizador);

        assertEquals(distanciaEsperada/velocidadKmh, temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs


    }

}
