package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//TODO: artefactos, etc dependen de la dificultad
public class RoboTest {
    @Test
    public void testInicializarRoboConGenerador() throws Exception { 
        Dificultad d = new Dificil();
        GeneradorMockDeRobo generador = new GeneradorMockDeRobo();
        Robo robo = new Robo(d, generador);
        
        assertEquals("Hola, Detective. Hubo un robo de Un artefacto Mock", 
            robo.reportarRobo("Detective"));
        assertEquals(robo.lugarDeRobo().toString(), "Zimbabwe");
    }

    @Test
    public void testInicializarRoboSinGenerador() throws Exception { 
        Dificultad d = new Dificil();
        Robo robo = new Robo(d, new GeneradorMockDeRobo());
        
        robo.reportarRobo("Detective");
            
    }

    @Test
    public void crearLadron() throws Exception {
        Ladron ladron = new Ladron("Roberto", "M", "", "", "tieneTatuaje", "Feo");
        assertEquals(ladron.genero().getClass(), GeneroMasculino.class);
        assertEquals(ladron.vehiculo(), "");
        assertEquals(ladron.cabello(), "");
        assertTrue(ladron.tieneAtributos("tieneTatuaje"));
        assertTrue(ladron.tieneAtributos("Feo"));
    }

    @Test
    public void crearRoboConGenerador() throws Exception {
        Robo robo = new Robo(new Dificil(), new GeneradorDeRobo());
        Pais lugarRobo = robo.lugarDeRobo();
        String artefacto = robo.nombreDeArtefacto();
        Ladron ladron = robo.obtenerLadron();

        assertNotEquals(null,lugarRobo);
        assertNotEquals(null,artefacto);
        assertNotEquals(null, ladron);
    }
}