package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdificioTest {

    @Test
    public void visitarVariasVeces() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;

        IRobo robo = new RoboMock();
        IPais Argentina = new PaisMock(robo.lugarDeRobo().nombre);
        Policia paco = new Policia(Argentina, new Temporizador(0));

        IEdificio aeropuerto = new Edificio ("aeropuerto", Argentina, new NoEstuvoEnEdificio());

        Argentina.agregarEdificio(aeropuerto);

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

        IPais pais = new PaisMock ("Francia");

        IEdificio banco = new Edificio ("banco", pais, new NoEstuvoEnEdificio());

        pistaObtenida = banco.obtenerTestimonio();

        assertEquals(pistaDeseada, pistaObtenida);

    }

}

