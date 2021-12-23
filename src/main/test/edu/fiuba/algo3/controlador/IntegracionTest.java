package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;

import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.policia.rangos.Novato;
import edu.fiuba.algo3.modelo.robo.GeneradorDeEdificios;
import edu.fiuba.algo3.modelo.robo.GeneradorDeRobo;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Robo;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        paco.asignarCaso(robo.primerPais(),estado,t, new ComputadoraMock());
    }
}