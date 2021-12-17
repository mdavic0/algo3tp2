package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

//TODO: artefactos, etc dependen de la dificultad
public class IntegracionTest {
    ITemporizador t = new TemporizadorMock();
    @Test
    public void inicializarJuego() throws Exception { 
       
        LectorDeArchivo lector = new LectorDeArchivo();
        Temporizador t = new Temporizador(9);
        Policia paco = new Policia();
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<IPais> paises =  lector.obtenerPaises();
        Robo robo = gRobo.generarRobo(new RangoMock(new Comun()), lector.obtenerArtefactos(), paises, lector.obtenerLadrones());
        assertEquals(robo.viaSinInit.size(), 4);

        GeneradorDeEdificios genEdificios = new GeneradorDeEdificios(robo, paco.rango);
        genEdificios.crearEdificiosPara(paises, robo, paco.rango.obtenerDificultadPistas());
        assertEquals( 3 ,robo.primerPais().edificios().size());


        EstadoDeJuego estado = new EstadoDeJuego();
        paco.asignarCaso(robo.primerPais(),estado,t);
    }
}