package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdificioTest {

    /*
    Vista un Aeropuerto (3 veces):
        Se despliega una pista.
    Vista un Puerto (55 veces):
        Se despliega una pista.
*/

    @Test
    public void visitarVariasVeces() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;
        int cantidadDeVisitasAlPuerto = 55;

        Pais Argentina = new Pais ("Argentina");
        Policia paco = new Policia(Argentina);

        Edificio aeropuerto = new Edificio ("aeropuerto", Argentina, tipoDeEdificio);
        Edificio puerto = new Edificio ("puerto", Argentina, tipoDeEdificio);

        Argentina.agregarEdificio(puerto);
        Argentina.agregarEdificio(aeropuerto);

        for (int x = 0; x < cantidadDeVisitasAlAeropuerto; x++){
            paco.entrarA(aeropuerto);
            paco.salirDelEdificio();
        }

        for (int x = 0; x < cantidadDeVisitasAlPuerto; x++){
            paco.entrarA(puerto);
            paco.salirDelEdificio();
        }

        assertEquals(cantidadDeVisitasAlAeropuerto, aeropuerto.cantidadDeVisitas());
        assertEquals(cantidadDeVisitasAlPuerto, puerto.cantidadDeVisitas());
    }

    @Test
    public void corroborarPista(){

        String pistaDeseada = "Pista banco 1";

        Pais Argentina = new Pais ("Argentina");
        Policia paco = new Policia(Argentina);

        Edificio banco = new Edificio ("banco", Argentina, tipoDeEdificio);




    }
}
