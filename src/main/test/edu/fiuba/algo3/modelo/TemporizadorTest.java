package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: Faltan mas tests UNITARIOS!
public class TemporizadorTest {
    @Test
    public void testCrearTemporizador() throws Exception { 
        int hora_inicial = 9;
        Temporizador timer = new Temporizador(hora_inicial); //hora inicial, hora_dormir, hora_limite
        ActividadMock actividad = new ActividadMock(5);
        actividad.reportar(timer);
        assertEquals(timer.horaActual(), hora_inicial + 5);
        assertEquals(timer.horasTranscurridas(), 5);
    }

    @Test
    public void testEventoQueDuraHastaLas23CausaSueño() throws Exception { 
        int hora_inicial = 9;
        Temporizador timer = new Temporizador(hora_inicial); //hora inicial, hora_dormir, hora_limite
        ActividadMock actividad = new ActividadMock(14);
        actividad.reportar(timer);

        //actividad termina a las 23:00 
        assertEquals(23, 9 + 14); 

        //Temporizador por sí solo no ocasiona sueño,
        assertEquals(14, timer.horasTranscurridas());
        assertEquals(((9 + 14) % 24), timer.horaActual()); 
    }

    @Test
    public void testEventoQueDura48HorasCausaFinDeJuego() throws Exception { 
        //Hack hasta implementar el sistema de eventos
        

        int hora_inicial = 9;
        Temporizador timer = new Temporizador(hora_inicial); //hora inicial, hora_dormir, hora_limite
        //assertEquals( "Activo", timer.estado);

        ActividadMock actividad = new ActividadMock(48);
        actividad.reportar(timer);

        //Hack hasta implementar el sistema de eventos
        //assertEquals( "Inactivo", timer.estado);
    }
}