package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneradorDeEdificiosTest {
    @Test
    public void testEdificioCreaPistasSegunDificultadFacilObtenidaDelRango() throws Exception {
        FabricaDePistas fabrica = new FabricaDePistas(new RoboMock());
        IPista pista = fabrica.crearPistaDeLectura(
            new PaisMock("Albania"), 
            new RangoMock(new Dificil()));
        assertEquals(pista.getClass(), PistaHistorica.class);
    }

    @Test
    public void testEdificioCreaPistasSegunDificultadMediaObtenidaDelRango() throws Exception {
        FabricaDePistas fabrica = new FabricaDePistas(new RoboMock());
        IPista pista = fabrica.crearPistaDeLectura(
            new PaisMock("Albania"), 
            new RangoMock(new Media()));
        assertEquals(pista.getClass(), PistaHistorica.class);
    }

    //TODO: mas tests para todas las configuraciones de tipo y dificultad
}
