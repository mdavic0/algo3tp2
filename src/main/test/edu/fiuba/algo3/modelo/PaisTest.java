package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//mover tests en policia test sobre paisesacá
public class PaisTest {
    //TODO: restaurar test usando un RoboMock

    @Test
    public void PaisCalculaDistanciaAOtroPais() throws Exception {
        IRobo robo = new RoboMock("Tiene una bandera roja", "Tiene una moto");
        Pais colombia = new Pais("Colombia", robo, 5, 5);
        Pais argentina = new Pais("Colombia", robo, 5, 5);
        int distanciaEsperada = 10;

        assertEquals(distanciaEsperada, colombia.distanciaA(argentina) );
    }
}