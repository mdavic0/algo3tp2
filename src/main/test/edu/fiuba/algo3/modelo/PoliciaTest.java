package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PoliciaTest {
    Temporizador t = new Temporizador(0, 20, 48);
    @Test
    public void testCuestionarTestigo() throws Exception {

        IPais colombia = new PaisMock("Colombia");
        IEdificio banco = new EdificioMock("El banco");
        colombia.agregarEdificio(banco);

        Policia paco = new Policia(colombia, t);
        assertThrows(Exception.class, () -> paco.cuestionarTestigo());
        paco.entrarA(banco);
        assertEquals("YO NO VI NADA!",paco.cuestionarTestigo());
    }

    @Test
    public void entrarAEdificioQueNoEstaEnPaisCausaExcepcion() throws Exception {
        IPais colombia = new PaisMock("Colombia");
        IEdificio e =  new EdificioMock("La ferreteria");
        Policia paco = new Policia(colombia, t);
        
        assertThrows(Exception.class, () -> paco.entrarA(e));
    }

    @Test
    public void entrarAEdificio() throws Exception {
        IPais colombia = new PaisMock("Colombia");
        IEdificio e =  new EdificioMock("La ferretería" );

        colombia.agregarEdificio(e);

        Policia paco = new Policia(colombia, t);
        
        paco.entrarA(e);
        
        assertThrows(Exception.class, () -> paco.entrarA(new EdificioMock("Migraciones")));
    }

    @Test
    public void viajarAUnPaisNoAccesibleCausaExcepcion() throws Exception {
        IPais montreal = new PaisMock("Montreal");
        IPais mexico = new PaisMock("México");
        montreal.conectarA(mexico);

        Policia paco = new Policia(montreal, t);

        assertThrows(Exception.class, () -> paco.viajarA(new PaisMock("China")));
    }

    @Test
    public void viajaDeMontrealAMéxico() throws Exception{
        IPais montreal = new PaisMock("Montreal");
        IPais mexico = new PaisMock("México");
        montreal.conectarA(mexico);
        Policia paco = new Policia(montreal, t);

        assertEquals(montreal.nombre(), paco.paisActual().toString());
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().toString());
    }

    @Test
    public void policiaHaceNArrestosYSubeDeRango() throws Exception{
        IPais colombia = new PaisMock("Colombia");
        Policia paco = new Policia(colombia, t);

        assertEquals(Novato.class, paco.rango.getClass());
        for(int i = 0; i < 5; i++){ paco.arrestarLadron(); }
        assertEquals(Detective.class, paco.rango.getClass());

        for(int i = 0; i < 5; i++){ paco.arrestarLadron(); }
        assertEquals(Investigador.class, paco.rango.getClass());

        for(int i = 0; i < 10; i++){ paco.arrestarLadron(); }
        assertEquals(Sargento.class, paco.rango.getClass());

    }
}

