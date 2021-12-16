package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
                new RangoMock(new ValorMedio()), 
                new LectorDeArchivo().obtenerArtefactos(), 
                new LectorDeArchivo().obtenerPaises(), 
                new LectorDeArchivo().obtenerLadrones());
                     
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
    @Test
    public void testGenerarPaisesParaUnRobo() throws Exception {
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<IPais> paises = new ArrayList<IPais>();
        paises.add(new PaisMock("Noruega"));
        paises.add(new PaisMock("Zimbabwe"));
        paises.add(new PaisMock("República checa"));
        paises.add(new PaisMock("Noruega2"));
        paises.add(new PaisMock("Zimbabwe2"));
        paises.add(new PaisMock("República checa2"));
        paises.add(new PaisMock("Noruega3"));
        paises.add(new PaisMock("Zimbabwe3"));
        paises.add(new PaisMock("República checa3"));
        paises.add(new PaisMock("Noruega4"));
        paises.add(new PaisMock("Zimbabwe4"));
        paises.add(new PaisMock("República checa4"));
        List<Artefacto> artefactos = new ArrayList<Artefacto>();
        artefactos.add(new Artefacto("Las pirámides", new ValorMedio()));
        List<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(new Ladron("Carmen", "F", "Moto", "Marrón", "Bien bonita", "Danza"));
        Robo robo = gRobo.generarRobo(new RangoMock(new ValorMedio()), artefactos, paises, ladrones);
        assertEquals(robo.viaSinInit.size(), 4);
        assertTrue(paises.containsAll(robo.viaSinInit));
        
    }
}
