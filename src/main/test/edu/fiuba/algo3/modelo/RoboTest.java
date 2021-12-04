package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//TODO: artefactos, etc dependen de la dificultad
public class RoboTest {
    LectorDeArchivo lector = new LectorDeArchivo();

    @Test
    public void testInicializarRoboConGenerador() throws Exception { 
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Bien bonita"),
            lector.obtenerArtefactos().get(0));
        
        assertEquals("Hola, Detective. Hubo un robo de La torre eiffel", 
            robo.reportarRobo("Detective"));
        
        assertNotEquals(robo.lugarDeRobo(), null);
        assertEquals(robo.lugarDeRobo().nombre, "Francia");
    }

    @Test
    public void testInicializarRoboSinGenerador() throws Exception { 
        Dificultad d = new Dificil();
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Bien bonita"),
            lector.obtenerArtefactos().get(0));
        
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
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Bien bonita"),
            lector.obtenerArtefactos().get(0));

        PaisSinPistas lugarRobo = robo.lugarDeRobo();
        String artefacto = robo.nombreDeArtefacto();
        Ladron ladron = robo.obtenerLadron();

        assertNotEquals(null,lugarRobo);
        assertNotEquals(null,artefacto);
        assertNotEquals(null, ladron);
    }

    @Test
    public void generarPistaParaPais() throws Exception {
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Bien bonita"),
            lector.obtenerArtefactos().get(0));

        // hack para obtener pais valido
        PaisSinPistas paisActual = robo.primerPais();
        assertNotEquals(robo.pistaParaPais(paisActual).contenido(), null);
    }

    @Test
    public void generarPistaParaLadron() throws Exception {
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Bien bonita"),
            lector.obtenerArtefactos().get(0));

        // hack para obtener pais valido
        PaisSinPistas pais = robo.primerPais();
        assertNotEquals(pais, null);
        assertNotEquals(robo.pistaParaLadron().contenido(), null);
    }
}