package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPista;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneradorDeEdificiosTest {

    @Test
    public void testEdificioCreaPistasSegunDificultadFacilObtenidaDelRango() throws Exception {
        Ladron carmen = new Ladron("Carmen Sandiego", "Femenino", "Moto", "Oscuro", "Bien bonita", "tenis");

        IDificultad dificultad = new Facil();
        IPista pista = dificultad.crearPistaHistorica(
            new PaisMock("Albania"), carmen);
        assertEquals(pista.getClass(), PistaCompuesta.class);
    }

    @Test
    public void testEdificioCreaPistasSegunDificultadMediaObtenidaDelRango() throws Exception {
        Ladron carmen = new Ladron("Carmen Sandiego", "Femenino", "Moto", "Oscuro", "Bien bonita", "tenis");

        IDificultad dificultad = new Media();
        IPista pista = dificultad.crearPistaHistorica(
            new PaisMock("Albania"), carmen);
        assertEquals(pista.getClass(), PistaCompuesta.class);
    }

    //TODO: mas tests para todas las configuraciones de tipo y dificultad
}
