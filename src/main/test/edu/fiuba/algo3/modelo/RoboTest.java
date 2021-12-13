package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//TODO: artefactos, etc dependen de la dificultad
public class RoboTest {
    LectorDeArchivo lector = new LectorDeArchivo();

    @Test
    public void testInicializarRoboConGenerador() throws Exception { 
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 2), 
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Anillo", "Tenis"),
            lector.obtenerArtefactos().get(0));
        
        assertEquals("Hola, Detective. Hubo un robo de La torre eiffel", 
            robo.reportarRobo("Detective"));
        
        assertNotEquals(robo.lugarDeRobo(), null);
        assertEquals(robo.lugarDeRobo().nombre(), "Francia");
    }

    @Test
    public void testInicializarRoboSinGenerador() throws Exception { 
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 2), 
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Anillo", "Tenis"),
            lector.obtenerArtefactos().get(0));
        
        robo.reportarRobo("Detective");
            
    }


    @Test
    public void crearRoboConGenerador() throws Exception {
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 2), 
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Anillo", "Tenis"),
            lector.obtenerArtefactos().get(0));

        IPais lugarRobo = robo.lugarDeRobo();
        String artefacto = robo.nombreDeArtefacto();
        Ladron ladron = robo.obtenerLadron();

        assertNotEquals(null,lugarRobo);
        assertNotEquals(null,artefacto);
        assertNotEquals(null, ladron);
    }

    @Test
    public void generarPistaParaPais() throws Exception {
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 2), 
            lector.obtenerPaises().subList(0, 3), 
            new Ladron("Carmen", "F", "Moto", "Marrón", "Anillo", "Tenis"),
            lector.obtenerArtefactos().get(0));

        // hack para obtener pais valido
        IPais paisActual = robo.primerPais();
        assertNotEquals(null, paisActual);
    }

    @Test
    public void generarPistaParaLadron() throws Exception {
        Robo robo = new Robo(
            lector.obtenerPaises().subList(0, 2), 
            lector.obtenerPaises().subList(0, 3),  
            new Ladron("Carmen", "F", "Moto", "Marrón", "Anillo", "Tenis"),
            lector.obtenerArtefactos().get(0));

        // hack para obtener pais valido
        IPais pais = robo.primerPais();
        assertNotEquals(pais, null);
        assertNotEquals(null, pais);
    }
}