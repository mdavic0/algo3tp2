package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RoboTest {
    List<IPais> paises;
    List<Artefacto> artefactos;
    
    @BeforeEach
    public void setUp() throws Exception{
        paises = new ArrayList<>();
        for(int i = 0; i < 23; i++)
            paises.add( new Pais("Francia" + i, 0, 0));

        this.artefactos = new ArrayList<>();
        Valor[] valores = {new Comun(), new Valioso(), new MuyValioso()};

        for(int j = 0; j < 3; j++) {
            Valor actual = valores[j];
            for(int i = 0; i < 20; i++) {
                artefactos.add(new Artefacto("La torre eiffel", actual));
            }
        }
    }

    @Test
    public void testInicializarRoboConGenerador() throws Exception { 


        Robo robo = new Robo(
            paises.subList(0, 2), 
            paises.subList(0, 6), 
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));
        
        assertEquals("Hola, Detective. Hubo un robo de La torre eiffel", 
            robo.reportarRobo("Detective"));
        
        assertNotEquals(robo.lugarDeRobo(), null);
        assertEquals(robo.lugarDeRobo().nombre(), "Francia0");
    }

    @Test
    public void testInicializarRoboSinGenerador() throws Exception { 
        Robo robo = new Robo(
            paises.subList(0, 2), 
            paises.subList(0, 6), 
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));
        
        robo.reportarRobo("Detective");
            
    }


    @Test
    public void crearRoboConGenerador() throws Exception {
        Robo robo = new Robo(
            paises.subList(0, 2), 
            paises.subList(0, 6), 
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));

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
            paises.subList(0, 2), 
            paises.subList(0, 6), 
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));

        // hack para obtener pais valido
        IPais paisActual = robo.primerPais();
        assertNotEquals(null, paisActual);
    }

    @Test
    public void generarPistaParaLadron() throws Exception {
        Robo robo = new Robo(
            paises.subList(0, 2), 
            paises.subList(0, 6),  
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));

        // hack para obtener pais valido
        IPais pais = robo.primerPais();
        assertNotEquals(pais, null);
        assertNotEquals(null, pais);
    }

    @Test
    public void generarConexionesEntrePaisesTest() throws Exception {
        Robo robo = new Robo(
            paises.subList(0, 2), 
            paises.subList(0, 6),  
            new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Anillo", "Tenis"),
            artefactos.get(0));
        for(IPais pais : robo.viaSinInit){
            assertFalse(pais.obtenerAdyacentes().contains(pais));
        }
    }
}