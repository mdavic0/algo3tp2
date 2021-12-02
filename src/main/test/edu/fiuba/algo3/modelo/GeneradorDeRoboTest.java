package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

public class GeneradorDeRoboTest {
    @Test
    public void testCrearViaDeViaje() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        List<PaisSinPistas> via = gen.viaDePaises(null);
        assertEquals(via.size(), 7);  
    }

    @Test
    public void testArtefacto() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Artefacto artefacto = gen.artefacto(null);
        assertNotEquals(artefacto, null);  
    }
}
