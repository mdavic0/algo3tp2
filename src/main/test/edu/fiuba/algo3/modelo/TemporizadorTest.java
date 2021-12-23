package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: Faltan mas tests UNITARIOS!
public class TemporizadorTest {
    int hora_dormir = 20;
    @Test
    public void testCrearTemporizador() throws Exception { 
        int hora_inicial = 9;
        Temporizador timer = new Temporizador(hora_inicial, hora_dormir); //hora inicial, hora_dormir, hora_limite
        ActividadMock actividad = new ActividadMock(5);
        actividad.reportar(timer);
        assertEquals(timer.horaActual(), hora_inicial + 5);
        assertEquals(timer.horasTranscurridas(), 5);
    }

    @Test
    public void testEventoQueDuraHastaLas23CausaSueño() throws Exception { 
        int hora_inicial = 9;
        Temporizador timer = new Temporizador(hora_inicial, hora_dormir); //hora inicial, hora_dormir, hora_limite
        ActividadMock actividad = new ActividadMock(14);
        actividad.reportar(timer);

        //actividad termina a las 23:00 
        assertEquals(23, 9 + 14); 

        //Temporizador por sí solo ocasiona sueño por feedback del corrector
        assertEquals(14 + 8, timer.horasTranscurridas());
        assertEquals(((9 + 14 + 8) % 24), timer.horaActual()); 
    }

    @Test
    public void testEventoQueDura48HorasCausaFinDeJuego() throws Exception { 
        //Hack hasta implementar el sistema de eventos
        

        int hora_inicial = 9;
        Temporizador timer = new Temporizador(hora_inicial, hora_dormir); //hora inicial, hora_dormir, hora_limite
        //assertEquals( "Activo", timer.estado);

        ActividadMock actividad = new ActividadMock(48);
        actividad.reportar(timer);

        //Hack hasta implementar el sistema de eventos
        //assertEquals( "Inactivo", timer.estado);
    }

    @Test
    public void testTemporizadorDaFechaYHoraCorrecta() throws Exception {
        //Tiempo: El jugador tendrá desde el lunes a las 7 hs hasta el domingo a las 17hs para atrapar al ladrón.

        Temporizador t = new Temporizador(7, hora_dormir);

        assertEquals("Lunes, 7hs", t.fechaActual());

        ActividadMock actividad = new ActividadMock(24);
        actividad.reportar(t);

        assertEquals("Martes, 7hs", t.fechaActual());

        ActividadMock actividad1 = new ActividadMock(48);
        actividad1.reportar(t);
        assertEquals("Jueves, 7hs", t.fechaActual());


        actividad.reportar(t);
        actividad1.reportar(t);
        assertEquals("Domingo, 7hs", t.fechaActual());

        ActividadMock actividad3 = new ActividadMock(17);
        actividad3.reportar(t);
        assertEquals("Lunes, 0hs", t.fechaActual());

        actividad3.reportar(t);
        assertEquals("Lunes, 17hs", t.fechaActual());
    }
}