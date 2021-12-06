package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdificioTest {

    @Test
    public void visitarVariasVeces() throws Exception {

        int cantidadDeVisitasAlAeropuerto = 3;

        IRobo robo = new RoboMock("holapais", "holaladron");
        IPais Argentina = new PaisMock(robo.lugarDeRobo().nombre);
        Policia paco = new Policia(Argentina, new Temporizador(0,0,0));

        IEdificio aeropuerto = new Edificio (
            "aeropuerto", Argentina, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(robo), Argentina)); // CAMBIAR
                                                                                                // TIPO DE EDIFICIO
        Argentina.agregarEdificio(aeropuerto);

        for (int x = 0; x < cantidadDeVisitasAlAeropuerto; x++){
            paco.entrarA(aeropuerto);
            paco.salirDelEdificio();
        }

        assertEquals(cantidadDeVisitasAlAeropuerto, aeropuerto.cantidadDeVisitas());

    }

    /*
    Los tests fallan porque no estamos creando un robo mock sino uno real que obtiene un pais
    aleatoriamente. Entonces para que el test funcione, debemos crear un robo Mock.
    El robo mock debe implementar pistaParaPais y pistaParaLadron que nos permita inyectar
    la pista que queremos.

    Ademas, para que los tipos de edificios funcionen, podemos generar los Testigos con una pista
    generada por el tipo de edificio:

    class EdificioEconomico
        crearTestigo(robo):
            return new Testigo(new PistaEconomica(robo))
    
    */
    @Test
    public void corroborarPista() throws Exception{

        String pistaDeseada = "Quería cambiar su dinero por MonedaMock.";
        String pistaObtenida;

        IRobo robo = new RoboMock("Holapais", "Holaladron");
        IPais pais = new PaisMock ("Francia");

        IEdificio banco = new Edificio (
            "banco", 
            pais, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(robo), pais));
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

