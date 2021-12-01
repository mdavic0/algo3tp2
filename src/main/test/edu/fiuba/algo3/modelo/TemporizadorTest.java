package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemporizadorTest {
    @Test
    public void testCrearTemporizador() throws Exception { 
        int hora_inicial = 9;
        int hora_dormir = 20;
        int hora_limite = 48;
        Temporizador timer = new Temporizador(hora_inicial, hora_dormir, hora_limite); //hora inicial, hora_dormir, hora_limite
        timer.reportarActividad(new Actividad(5));
        assertEquals(timer.horaActual(), hora_inicial + 5);
        assertEquals(timer.horasTranscurridas(), 5);
    }

    @Test
    public void testEventoQueDuraHastaLas23CausaSueño() throws Exception { 
        int hora_inicial = 9;
        int hora_dormir = 23;
        int hora_limite = 48;
        Temporizador timer = new Temporizador(hora_inicial, hora_dormir, hora_limite); //hora inicial, hora_dormir, hora_limite
        timer.reportarActividad(new Actividad(14));

        assertEquals(23, 9 + 14); //actividad termina a las 23:00 
        assertEquals(14 + 8, timer.horasTranscurridas());
        assertEquals(((9 + 14 + 8) % 24), timer.horaActual()); //horaActual() provee el horario entre 0 y 23 horas
    }
}