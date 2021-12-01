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
    }
}