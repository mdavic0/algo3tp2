package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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


}
