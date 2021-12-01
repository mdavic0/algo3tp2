package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PoliciaTest {
    @Test
    public void testCuestionarTestigo() throws Exception {
        Pais colombia = new Pais("Colombia");
        Edificio banco = new Edificio("El banco", colombia);
        colombia.agregarEdificio(banco);

        Policia paco = new Policia(colombia);
        assertThrows(Exception.class, () -> paco.cuestionarTestigo());
        paco.entrarA(banco);
        assertEquals("YO NO VI NADA!!!!",paco.cuestionarTestigo());
    }

    @Test
    public void entrarAEdificioQueNoEstaEnPaisCausaExcepcion() throws Exception {
        Pais colombia = new Pais("Colombia");
        Edificio e =  new Edificio("La ferretería", colombia);
        Policia paco = new Policia(colombia);
        
        assertThrows(Exception.class, () -> paco.entrarA(e));
    }

    @Test
    public void entrarAEdificio() throws Exception {
        Pais colombia = new Pais("Colombia");
        Edificio e =  new Edificio("La ferretería", colombia);
        colombia.agregarEdificio(e);

        Policia paco = new Policia(colombia);
        
        paco.entrarA(e);
        assertThrows(Exception.class, () -> paco.entrarA(new Edificio("Migraciones", colombia)));
    }

    @Test
    public void viajarAUnPaisNoAccesibleCausaExcepcion() throws Exception {
        Pais montreal = new Pais("Montreal");
        Pais mexico = new Pais("México");
        montreal.conectarA(mexico);

        Policia paco = new Policia(montreal);

        assertThrows(Exception.class, () -> paco.viajarA(new Pais("China")));
    }

    @Test
    public void viajaDeMontrealAMéxico() throws Exception{
        Pais montreal = new Pais("Montreal");
        Pais mexico = new Pais("México");
        montreal.conectarA(mexico);
        Policia paco = new Policia(montreal);

        assertEquals(montreal.nombre, paco.paisActual().toString());
        paco.viajarA(mexico);
        assertEquals(mexico.nombre, paco.paisActual().toString());
    }
}

