package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.pistas.PistaDeLadron;
import edu.fiuba.algo3.modelo.pistas.PistaDeMoneda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PistaTest {

    @Test
    public void PistaDeLadronDaPistaDeLadron() throws Exception {
        Pista pista = new PistaDeLadron("Tenia un tatuaje");

        assertEquals("Tenia un tatuaje", pista.contenido());
    }


    @Test
    public void PistaDeLecturaDaPistaDeLectura() throws Exception {
        Pista pista = new PistaDeMoneda("reales");

        assertEquals("Quería cambiar su dinero por reales. ", pista.contenido());
    }


}
