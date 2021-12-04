package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2Test {
    @Test
    public void PoliciaSufreUnaHeridaDeCuchilloYDuerme() throws Exception {
        IPais montreal = new PaisMock("Montreal");
        Temporizador t = new Temporizador(16, 20, 36);
        Policia undyne = new Policia(montreal, t);

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 2); //Herida con un cuchillo:2 hs la primera vez, 1 hs las próximas veces.

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 3);

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 4 + 8);
    }

    }
