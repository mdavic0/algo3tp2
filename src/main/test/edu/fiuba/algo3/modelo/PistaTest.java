package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PistaTest {

    @Test
    public void PistaDeContinenteDaPistaDeContinente() throws Exception {
        IPista pista = new PistaDeContinente("Europa");

        assertEquals("Quería viajar a algún lugar en Europa.", pista.contenido());

    }

    @Test
    public void PistaDeFuenteDeIngresoDaPistaDeFuenteDeIngreso() throws Exception {
        IPista pista = new PistaDeFuenteDeIngreso("venta de drogas");

        assertEquals("Su fuente de ingreso es/son venta de drogas.", pista.contenido());
    }

    @Test
    public void PistaDeLadronDaPistaDeLadron() throws Exception {
        IPista pista = new PistaDeLadron("Tenia un tatuaje");

        assertEquals("Tenia un tatuaje", pista.contenido());
    }

    @Test
    public void PistaDeMonedaDaPistaDeMoneda() throws Exception {
        IPista pista = new PistaDeLectura("Los secretos del printf");

        assertEquals("Quería leer el libro Los secretos del printf.", pista.contenido());
    }


    @Test
    public void PistaDeLecturaDaPistaDeLectura() throws Exception {
        IPista pista = new PistaDeMoneda("reales");

        assertEquals("Quería cambiar su dinero por reales.", pista.contenido());
    }

    @Test
    public void PistaHistoricaDaPistaHistorica() throws Exception {
        IPista pista = new PistaHistorica("Hubo una guerra que duro 10 decadas");

        assertEquals("Me contó algo muy interesante de ese pais. Hubo una guerra que duro 10 decadas", pista.contenido());
    }



}
