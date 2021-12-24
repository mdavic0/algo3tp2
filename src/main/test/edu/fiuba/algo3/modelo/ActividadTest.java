package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.actividades.*;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActividadTest {

    @Test
    public void DormirCausaUnIncrementoHorarioDe8hs() throws Exception {
        int horaInicial = 0;
        int horaDormir = 20;
        Temporizador temporizador = new Temporizador(horaInicial, horaDormir);
         Actividad actividad = new Dormir();

         actividad.reportar(temporizador);

         assertEquals(8, temporizador.horasTranscurridas());
     }

     @Test
     public void EmitirOrdenDeArrestoCausaUnIncrementoHorarioDe3hs() throws Exception {
        int horaInicial = 0;
        int horaDormir = 20;
         Temporizador temporizador = new Temporizador(horaInicial, horaDormir);
         Actividad actividad = new EmitirOrdenDeArresto();

         actividad.reportar(temporizador);

         assertEquals(3, temporizador.horasTranscurridas());
    }

    @Test
    public void EntrarAEdificioCausaUnIncrementoHorarioDe1hLaPrimeraVez2hsLaSegundaYLuegoSiempre3hs() throws Exception {
        int horaInicial = 0;
        int horaDormir = 20;
        Temporizador temporizador = new Temporizador(horaInicial, horaDormir);

        Actividad actividad = new EntrarAEdificio(1);
        actividad.reportar(temporizador);
        assertEquals(1, temporizador.horasTranscurridas());

        Actividad actividad2 = new EntrarAEdificio(2);
        actividad2.reportar(temporizador);
        assertEquals(1 + 2, temporizador.horasTranscurridas());

        Actividad actividad3 = new EntrarAEdificio(3);
        actividad3.reportar(temporizador);
        assertEquals(1 + 2 + 3, temporizador.horasTranscurridas());

    }

    @Test
    public void HeridaConArmaDeFuegoCausaUnIncrementoHorarioDe4hs() throws Exception {
        int horaInicial = 0;
        int horaDormir = 20;
        int duracionHeridaArma = 4;
        Temporizador temporizador = new Temporizador(horaInicial, horaDormir);
        Actividad actividad = new HeridaConArmaDeFuego();

        actividad.reportar(temporizador);

        assertEquals(duracionHeridaArma, temporizador.horasTranscurridas());
    }

    @Test
    public void HeridaConCuchilloCausaUnIncrementoHorarioDe2hsLaPrimeraVezY1hsLasProximasVeces() throws Exception {
        int horaInicial = 0;
        int horaDormir = 20;
        Temporizador temporizador = new Temporizador(horaInicial, horaDormir);

        Actividad actividad = new HeridaConCuchillo(1);
        actividad.reportar(temporizador);
        assertEquals(2, temporizador.horasTranscurridas());

        Actividad actividad2 = new HeridaConCuchillo(2);
        actividad2.reportar(temporizador);
        assertEquals(2 + 1, temporizador.horasTranscurridas());

        Actividad actividad3 = new HeridaConCuchillo(3);
        actividad3.reportar(temporizador);
        assertEquals(2 + 1 + 1, temporizador.horasTranscurridas());
    }

    @Test
    public void ViajarCausaUnIncrementoHorarioQueDependeDeLaDistanciaDeUnPaisAOtroPais() throws Exception {
        Pais colombia = new Pais("Colombia", 4.570868, -74.297333); //https://www.geodatos.net/coordenadas/colombia
        Pais argentina = new Pais("Argentina", -38.416097, -63.616672); // https://www.geodatos.net/coordenadas/argentina

        double distanciaEsperada = 4905; //https://www.entfernungsrechner.net/es/distance/country/co/country/ar

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina), 50); // Distancia aproximada, usando un delta verificamos la precision

        Temporizador temporizador = new Temporizador(0, 20);
        double velocidadKmh = 1000.0;
        Actividad actividad = new Viajar(colombia, argentina, velocidadKmh);
        actividad.reportar(temporizador);

        assertEquals(distanciaEsperada/velocidadKmh, temporizador.horasTranscurridas(),1); //Duracion aproximada, usando delta de 1hs


    }

}
