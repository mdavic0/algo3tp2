package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdificioTest {

    @Test
    public void visitarVariasVeces() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;

        Robo robo = new Robo(new Dificil());
        IPais Argentina = new PaisMock(robo.lugarDeRobo().nombre);
        Policia paco = new Policia(Argentina);

        IEdificio aeropuerto = new Edificio ("aeropuerto", Argentina, new Robo(new Dificil()), new EdificioEconomico()); // CAMBIAR
                                                                                                // TIPO DE EDIFICIO
        Argentina.agregarEdificio(aeropuerto);

        for (int x = 0; x < cantidadDeVisitasAlAeropuerto; x++){
            paco.entrarA(aeropuerto);
            paco.salirDelEdificio();
        }

        assertEquals(cantidadDeVisitasAlAeropuerto, aeropuerto.cantidadDeVisitas());

    }

    @Test
    public void corroborarPista() throws Exception{

        String pistaDeseada = "pista economica 01";
        String pistaObtenida;

        Robo robo = new Robo(new Dificil());
        IPais pais = new PaisMock (robo.lugarDeRobo().nombre);
        Policia paco = new Policia(pais);

        IEdificio banco = new Edificio ("banco", pais, robo, new EdificioEconomico());

        pais.agregarEdificio(banco);

        pistaObtenida = banco.obtenerTestimonio();

        assertEquals(pistaDeseada, pistaObtenida);

    }


    /*
    Vista un Aeropuerto (3 veces):
        Se despliega una pista.
    Vista un Puerto (55 veces):
        Se despliega una pista.
    */
}

