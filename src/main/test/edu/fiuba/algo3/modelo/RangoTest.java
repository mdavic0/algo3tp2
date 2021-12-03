package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RangoTest {
    @Test
    public void NovatoCalculaSuVelocidadKmh() throws Exception {
        Rango novato = new Novato();
        double valorEsperado = 900;

        assertEquals(valorEsperado, novato.velocidadKmh());
    }

    @Test
    public void DetectiveCalculaSuVelocidadKmh() throws Exception {
        Rango detective = new Detective();
        double valorEsperado = 1100;

        assertEquals(valorEsperado, detective.velocidadKmh());
    }

    @Test
    public void InvestigadorCalculaSuVelocidadKmh() throws Exception {
        Rango investigador = new Investigador();
        double valorEsperado = 1300;

        assertEquals(valorEsperado, investigador.velocidadKmh());
    }

    @Test
    public void SargentoCalculaSuVelocidadKmh() throws Exception {
        Rango sargento = new Sargento();
        double valorEsperado = 1500;

        assertEquals(valorEsperado, sargento.velocidadKmh());
    }

}
