package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class GeneradorDeRoboTest {
    @Test
    public void testCrearViaDeViaje() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        List<Pais> via = gen.viaDePaises(null);
        assertEquals(via.size(), 7);  
    }
    
}
