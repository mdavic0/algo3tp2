package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//TODO: Faltan mas tests UNITARIOS!
public class TemporizadorTest {
    @Test
    public void testCrearTemporizador() throws Exception { 
        int hora_inicial = 9;
        int hora_dormir = 20;
        int hora_limite = 48;
        Temporizador timer = new Temporizador(hora_inicial); //hora inicial, hora_dormir, hora_limite
        ActividadMock actividad = new ActividadMock(5);
        actividad.reportar(timer);
        assertEquals(timer.horaActual(), hora_inicial + 5);
        assertEquals(timer.horasTranscurridas(), 5);
    }

    @Test
    public void testEventoQueDuraHastaLas23CausaSueño() throws Exception { 
        int hora_inicial = 9;
        int hora_dormir = 23;
        int hora_limite = 48;
        Temporizador timer = new Temporizador(hora_inicial); //hora inicial, hora_dormir, hora_limite
        ActividadMock actividad = new ActividadMock(14);
        actividad.reportar(timer);

        assertEquals(23, 9 + 14); //actividad termina a las 23:00 
        assertEquals(14 + 8, timer.horasTranscurridas());
        assertEquals(((9 + 14 + 8) % 24), timer.horaActual()); //horaActual() provee el horario entre 0 y 23 horas
    }

    @Test
    public void testEventoQueDura48HorasCausaFinDeJuego() throws Exception { 
        //Hack hasta implementar el sistema de eventos
        

        int hora_inicial = 9;
        int hora_dormir = 23;
        int hora_limite = 48;
        Temporizador timer = new Temporizador(hora_inicial); //hora inicial, hora_dormir, hora_limite
        //assertEquals( "Activo", timer.estado);

        ActividadMock actividad = new ActividadMock(48);
        actividad.reportar(timer);

        //Hack hasta implementar el sistema de eventos
        //assertEquals( "Inactivo", timer.estado);
    }
}