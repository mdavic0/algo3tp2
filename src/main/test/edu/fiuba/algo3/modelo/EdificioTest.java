package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdificioTest {

    @Test
    public void visitarVariasVeces() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;

        IPais Argentina = new PaisMock ("Argentina");
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

        IPais Argentina = new PaisMock ("Argentina");
        Policia paco = new Policia(Argentina);

        IEdificio banco = new Edificio ("banco", Argentina, new Robo(new Dificil()), new EdificioEconomico());

        Argentina.agregarEdificio(banco);

        pistaObtenida = banco.obtenerTestimonio();

        assertEquals(pistaDeseada, pistaObtenida);

    }


    /*
    Vista un Aeropuerto (3 veces):
        Se despliega una pista.
    Vista un Puerto (55 veces):
        Se despliega una pista.
    */

    @Test
    public void visitarVariasVecesElPuertoYAeropuerto() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;
        int cantidadDeVisitasAlPuerto = 55;

        String pistaDeseada = "pista de viaje 01";
        String pistaObtenidaPuerto = " ";
        String pistaObtenidaAeroPuerto = " ";

        IPais Argentina = new PaisMock ("Argentina");
        Policia paco = new Policia(Argentina);

        Edificio aeropuerto = new Edificio ("aeropuerto", Argentina,null, new EdificioDeViaje());
        Edificio puerto = new Edificio ("puerto", Argentina, null, new EdificioDeViaje());

        Argentina.agregarEdificio(puerto);
        Argentina.agregarEdificio(aeropuerto);

        for (int x = 0; x < cantidadDeVisitasAlAeropuerto; x++){
            paco.entrarA(aeropuerto);
            paco.salirDelEdificio();
            pistaObtenidaPuerto = puerto.seleccionarPista();
        }

        for (int x = 0; x < cantidadDeVisitasAlPuerto; x++){
            paco.entrarA(puerto);
            paco.salirDelEdificio();
            pistaObtenidaAeroPuerto = aeropuerto.seleccionarPista();
        }

        assertEquals(cantidadDeVisitasAlAeropuerto, aeropuerto.cantidadDeVisitas());
        assertEquals(cantidadDeVisitasAlPuerto, puerto.cantidadDeVisitas());
        assertEquals(pistaDeseada, pistaObtenidaPuerto);
        assertEquals(pistaDeseada, pistaObtenidaAeroPuerto);
    }
}

