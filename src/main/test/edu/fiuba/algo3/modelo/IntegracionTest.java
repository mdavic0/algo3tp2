package edu.fiuba.algo3.modelo;

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
    private List<Ladron> ladrones;
    
    @BeforeEach
    public void setUp() throws Exception{
        paises = new ArrayList<>();
        for(int i = 0; i < 23; i++)
            paises.add( new Pais("Francia" + i, 0, 0));

        this.artefactos = new ArrayList<>();
        Valor[] valores = {new Comun(), new Valioso(), new MuyValioso()};

        for(int j = 0; j < 3; j++) {
            Valor actual = valores[j];
            for(int i = 0; i < 20; i++) {
                artefactos.add(new Artefacto("La torre eiffel", actual));
            }
        }
        
        ladrones = new ArrayList<>();
        ladrones.add( new Ladron("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Alonzo", "M", "Deportivo","Rubio", "Anillo","Tenis"));
        ladrones.add(new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis"));
   
    }
    @Test
    public void inicializarJuego() throws Exception { 
        Temporizador t = new Temporizador(9, 21);
        Policia paco = new Policia();
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<IPais> paises =  this.paises;
        Robo robo = gRobo.generarRobo(new RangoMock(new Comun()), artefactos, paises,ladrones);
        assertEquals(robo.viaSinInit.size(), 4);

        GeneradorDeEdificios genEdificios = new GeneradorDeEdificios(robo, paco.rango);
        genEdificios.crearEdificiosPara(paises, robo);
        assertEquals( 3 ,robo.primerPais().edificios().size());


        EstadoDeJuego estado = new EstadoDeJuego();
        paco.asignarCaso(robo.primerPais(),estado,t);
    }
}