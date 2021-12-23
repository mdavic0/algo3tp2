package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PoliciaTest {
    ITemporizador t = new TemporizadorMock();
    @Test
    public void testCuestionarTestigo() throws Exception {

        IPais colombia = new PaisMock("Colombia");
        IEdificio banco = new EdificioMock("El banco");
        colombia.agregarEdificios(banco);

        Policia paco = new Policia();
        paco.asignarCaso(colombia, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());
        assertThrows(Exception.class, () -> paco.cuestionarTestigo());
        paco.entrarA(banco);
        assertEquals("YO NO VI NADA!",paco.cuestionarTestigo());
    }

    @Test
    public void entrarAEdificioQueNoEstaEnPaisCausaExcepcion() throws Exception {
        IEdificio e =  new EdificioMock("La ferreteria");
        Policia paco = new Policia();
        
        assertThrows(Exception.class, () -> paco.entrarA(e));
    }

    @Test
    public void entrarAEdificio() throws Exception {
        IPais colombia = new PaisMock("Colombia");
        IEdificio e =  new EdificioMock("La ferretería" );

        colombia.agregarEdificios(e);

        Policia paco = new Policia();
        paco.asignarCaso(colombia, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());
        paco.entrarA(e);
        
        assertThrows(Exception.class, () -> paco.entrarA(new EdificioMock("Migraciones")));
    }

    @Test
    public void viajarAUnPaisNoAccesibleCausaExcepcion() throws Exception {
        IPais montreal = new PaisMock("Montreal");
        IPais mexico = new PaisMock("México");
        montreal.conectarA(mexico);

        Policia paco = new Policia();
        paco.asignarCaso(montreal, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());

        assertThrows(Exception.class, () -> paco.viajarA(new PaisMock("China")));
    }

    @Test
    public void viajaDeMontrealAMéxico() throws Exception{
        IPais montreal = new PaisMock("Montreal");
        IPais mexico = new PaisMock("México");
        montreal.conectarA(mexico);
        Policia paco = new Policia();
        paco.asignarCaso(montreal, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());

        assertEquals(montreal.nombre(), paco.paisActual().nombre());
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());
    }

    @Test
    public void policiaHaceNArrestosYSubeDeRango() throws Exception{
        IPais colombia = new PaisMock("Colombia");
        Policia paco = new Policia();

        assertEquals(Novato.class, paco.rango.getClass());
        for(int i = 0; i < 5; i++){ paco.arrestarLadron(); }
        assertEquals(Detective.class, paco.rango.getClass());

        for(int i = 0; i < 5; i++){ paco.arrestarLadron(); }
        assertEquals(Investigador.class, paco.rango.getClass());

        for(int i = 0; i < 10; i++){ paco.arrestarLadron(); }
        assertEquals(Sargento.class, paco.rango.getClass());

    }
}

