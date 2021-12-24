package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.policia.rangos.Detective;
import edu.fiuba.algo3.modelo.policia.rangos.Investigador;
import edu.fiuba.algo3.modelo.policia.rangos.Novato;
import edu.fiuba.algo3.modelo.policia.rangos.Sargento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PoliciaTest {
    Temporizador t = new TemporizadorMock();
    @Test
    public void testCuestionarTestigo() throws Exception {

        Pais colombia = new PaisMock("Colombia");
        Edificio banco = new EdificioMock("El banco");
        colombia.agregarEdificios(banco);

        Policia paco = new Policia();
        paco.asignarCaso(colombia, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());
        assertThrows(Exception.class, () -> paco.cuestionarTestigo());
        paco.entrarA(banco);
        assertEquals("YO NO VI NADA!",paco.cuestionarTestigo());
    }

    @Test
    public void entrarAEdificioQueNoEstaEnPaisCausaExcepcion() throws Exception {
        Edificio e =  new EdificioMock("La ferreteria");
        Policia paco = new Policia();
        
        assertThrows(Exception.class, () -> paco.entrarA(e));
    }

    @Test
    public void entrarAEdificio() throws Exception {
        Pais colombia = new PaisMock("Colombia");
        Edificio e =  new EdificioMock("La ferretería" );

        colombia.agregarEdificios(e);

        Policia paco = new Policia();
        paco.asignarCaso(colombia, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());
        paco.entrarA(e);
        
        assertThrows(Exception.class, () -> paco.entrarA(new EdificioMock("Migraciones")));
    }

    @Test
    public void viajarAUnPaisNoAccesibleCausaExcepcion() throws Exception {
        Pais montreal = new PaisMock("Montreal");
        Pais mexico = new PaisMock("México");
        montreal.conectarA(mexico);

        Policia paco = new Policia();
        paco.asignarCaso(montreal, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());

        assertThrows(Exception.class, () -> paco.viajarA(new PaisMock("China")));
    }

    @Test
    public void viajaDeMontrealAMéxico() throws Exception{
        Pais montreal = new PaisMock("Montreal");
        Pais mexico = new PaisMock("México");
        montreal.conectarA(mexico);
        Policia paco = new Policia();
        paco.asignarCaso(montreal, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());

        assertEquals(montreal.nombre(), paco.paisActual().nombre());
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());
    }

    @Test
    public void policiaHaceNArrestosYSubeDeRango() throws Exception{
        Pais colombia = new PaisMock("Colombia");
        Policia paco = new Policia();

        assertEquals(Novato.class, paco.obtenerRango().getClass());
        for(int i = 0; i < 5; i++){ paco.arrestarLadron(); }
        assertEquals(Detective.class, paco.obtenerRango().getClass());

        for(int i = 0; i < 5; i++){ paco.arrestarLadron(); }
        assertEquals(Investigador.class, paco.obtenerRango().getClass());

        for(int i = 0; i < 10; i++){ paco.arrestarLadron(); }
        assertEquals(Sargento.class, paco.obtenerRango().getClass());

    }
}

