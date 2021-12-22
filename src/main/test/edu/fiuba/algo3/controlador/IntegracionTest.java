package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.controlador.LectorDeArchivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;


public class IntegracionTest {
    ITemporizador t = new TemporizadorMock();
    List<IPais> paises;
    List<Artefacto> artefactos;
    List<Ladron> ladrones;
    LectorDeArchivo l = new LectorDeArchivo();
    
    @BeforeEach
    public void setUp() throws Exception{
        this.paises = l.obtenerPaises();
        this.artefactos = l.obtenerArtefactos();
        this.ladrones = l.obtenerLadrones();
    }

    @Test
    public void inicializarJuego() throws Exception { 
        Temporizador t = new Temporizador(9, 21);
        Policia paco = new Policia();
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<IPais> paises =  this.paises;
        Robo robo = gRobo.generarRobo(new RangoMock(new Comun()), artefactos, paises,ladrones);
        assertEquals(4, robo.viaSinInit().size());

        GeneradorDeEdificios genEdificios = new GeneradorDeEdificios(robo, new Novato());
        genEdificios.crearEdificiosPara(paises, robo);
        assertEquals( 3 ,robo.primerPais().edificios().size());


        EstadoDeJuego estado = new EstadoDeJuego();
        paco.asignarCaso(robo.primerPais(),estado,t);
    }
}