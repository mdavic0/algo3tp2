package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GeneradorDeRoboTest {
    @Test
    public void testCrearRobo() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Sargento(), new LectorDeArchivo().obtenerArtefactos(), new LectorDeArchivo().obtenerPaises(), new LectorDeArchivo().obtenerLadrones());
                    
        assertNotEquals(null, robo);
        assertEquals(robo.nombreDeArtefacto(), "La torre eiffel" );
        
    }
    @Test
    public void testCrearRoboDeObjetoValorMedio() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Sargento(), new LectorDeArchivo().obtenerArtefactos(), new LectorDeArchivo().obtenerPaises(), new LectorDeArchivo().obtenerLadrones());
                     
        assertEquals(ValorMedio.class , robo.artefacto.valor().getClass());
        
    }
    @Test
    public void testCrearRoboDeObjetoMuyValioso() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Sargento(), new LectorDeArchivo().obtenerArtefactos(), new LectorDeArchivo().obtenerPaises(), new LectorDeArchivo().obtenerLadrones());
                
        assertEquals(MuyValioso.class , robo.artefacto.valor().getClass());
        
    }
    @Test
    public void testObjetoMuyValiosoImplica7PaisesDeViaje() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new RangoMock(new MuyValioso()), new LectorDeArchivo().obtenerArtefactos(), new LectorDeArchivo().obtenerPaises(), new LectorDeArchivo().obtenerLadrones());
               
        assertEquals(7 , robo.viaSinInit.size());
        
    }
    @Test
    public void testObjetoValorMedioImplica4PaisesDeViaje() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new RangoMock(new ValorMedio()), new LectorDeArchivo().obtenerArtefactos(), new LectorDeArchivo().obtenerPaises(), new LectorDeArchivo().obtenerLadrones());
                    
        assertEquals(4 , robo.viaSinInit.size());
        
    }
}
