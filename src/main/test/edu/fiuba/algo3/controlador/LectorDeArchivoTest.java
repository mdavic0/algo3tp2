package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Artefacto;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.controlador.LectorDeArchivo;
import edu.fiuba.algo3.modelo.Ladron;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorDeArchivoTest {

    @Test
    public void TestLectorLeeLadronesDeJSON() throws Exception {
        LectorDeArchivo l = new LectorDeArchivo();
        List<Ladron> ladrones = l.obtenerLadrones();

        assertEquals(10,  ladrones.size());
    }

    @Test
    public void TestLectorLeeArtefactosDeJSON() throws Exception {
        LectorDeArchivo l = new LectorDeArchivo();
        List<Artefacto> artefactos = l.obtenerArtefactos();

        assertEquals(28,  artefactos.size());
    }


}
