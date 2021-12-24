package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.NoEstuvoEnEdificio;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.robo.Robo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdificioTest {

    @Test
    public void visitarVariasVeces() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;

        Robo robo = new RoboMock();
        Pais Argentina = new PaisMock(robo.lugarDeRobo().nombre());
        Policia paco = new Policia(); //Argentina, new Temporizador(0)
        paco.asignarCaso(Argentina, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());

        Edificio aeropuerto = new Edificio("aeropuerto", Argentina, new NoEstuvoEnEdificio());

        Argentina.agregarEdificios(aeropuerto);

        for (int x = 0; x < cantidadDeVisitasAlAeropuerto; x++){
            paco.entrarA(aeropuerto);
            paco.salirDelEdificio();
        }

        assertEquals(cantidadDeVisitasAlAeropuerto, aeropuerto.cantidadDeVisitas());

    }

    @Test
    public void corroborarPista() throws Exception{

        String pistaDeseada = "Lo siento, no he visto a nadie parecido por esta zona...";
        String pistaObtenida;

        Pais pais = new PaisMock ("Francia");

        Edificio banco = new Edificio ("banco", pais, new NoEstuvoEnEdificio());

        pistaObtenida = banco.obtenerTestimonio();

        assertEquals(pistaDeseada, pistaObtenida);

    }

}

