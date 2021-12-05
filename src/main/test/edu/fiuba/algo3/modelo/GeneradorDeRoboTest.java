package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

public class GeneradorDeRoboTest {
    @Test
    public void testCrearRobo() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Dificil(), new Novato(), new LectorDeArchivo());
                
        assertNotEquals(null, robo);
        assertEquals(robo.nombreDeArtefacto(), "La torre eiffel" );
        
    }
    @Test
    public void testCrearRoboDeObjetoValorMedio() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Facil(), new Novato(), new LectorDeArchivo());
                
        assertEquals(ValorMedio.class , robo.artefacto.valor().getClass());
        
    }
    @Test
    public void testCrearRoboDeObjetoMuyValioso() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Facil(), new Sargento(), new LectorDeArchivo());
                
        assertEquals(MuyValioso.class , robo.artefacto.valor().getClass());
        
    }
}
