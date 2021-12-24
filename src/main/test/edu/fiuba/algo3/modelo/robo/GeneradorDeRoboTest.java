package edu.fiuba.algo3.modelo.robo;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.PaisMock;
import edu.fiuba.algo3.modelo.RangoMock;
import edu.fiuba.algo3.modelo.policia.rangos.Sargento;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class GeneradorDeRoboTest {

    List<Pais> paises;
    List<Artefacto> artefactos;
    private List<Ladron> ladrones;
    
    @BeforeEach
    public void setUp() throws Exception{
        paises = new ArrayList<>();
        for(int i = 0; i < 23; i++)
            paises.add( new Pais("", "", "", "", "",
                    "", "", "", "", "", "", "",
                    "", "", 0, 0));

        this.artefactos = new ArrayList<>();
        Valor[] valores = {new Comun(), new Valioso(), new MuyValioso()};

        for(int j = 0; j < 3; j++) {
            Valor actual = valores[j];
            for(int i = 0; i < 20; i++) {
                artefactos.add(new Artefacto("La torre eiffel", actual));
            }
        }

        ladrones = new ArrayList<>();
        ladrones.add( new Ladron("Juan", "Masculino", "Deportivo", "Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Roberta Rigoberta", "Femenino", "Motocicleta","Negro", "Cicatriz","Musica"));
        ladrones.add( new Ladron("Alonzo", "Masculino", "Deportivo","Rubio", "Anillo","Tenis"));
        ladrones.add(new Ladron("Carmen Sandiego", "Femenino", "Moto", "Oscuro", "Bien bonita", "tenis"));
    }
    
    @Test
    public void testCrearRobo() throws Exception {
        
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new Sargento(), artefactos, paises, ladrones);
                    
        assertNotEquals(null, robo);
        assertEquals(robo.nombreDeArtefacto(), "La torre eiffel" );
        
    }
    @Test
    public void testCrearRoboDeObjetoValorComun() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new RangoMock(new Comun()),
                artefactos, 
                paises, 
                ladrones);
                     
        assertEquals(Comun.class , robo.artefacto.valor().getClass());
        
    }
    @Test
    public void testCrearRoboDeObjetoMuyValioso() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new RangoMock(new MuyValioso()), artefactos, paises, ladrones);
                
        assertEquals(MuyValioso.class , robo.artefacto.valor().getClass());
        
    }
    @Test
    public void testObjetoMuyValiosoImplica7PaisesDeViaje() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new RangoMock(new MuyValioso()), artefactos, paises, ladrones);
               
        assertEquals(7 , robo.viaSinInit.size());
        
    }
    @Test
    public void testObjetoValorMedioImplica4PaisesDeViaje() throws Exception {
        GeneradorDeRobo gen = new GeneradorDeRobo();
        Robo robo = gen.generarRobo(
                new RangoMock(new Comun()), artefactos, paises, ladrones);
                    
        assertEquals(4 , robo.viaSinInit.size());
        
    }
    @Test
    public void testGenerarPaisesParaUnRobo() throws Exception {
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<Pais> paises = new ArrayList<Pais>();
        paises.add(new PaisMock("Noruega"));
        paises.add(new PaisMock("Zimbabwe"));
        paises.add(new PaisMock("República checa"));
        paises.add(new PaisMock("Noruega2"));
        paises.add(new PaisMock("Zimbabwe2"));
        paises.add(new PaisMock("República checa2"));
        paises.add(new PaisMock("Noruega3"));
        paises.add(new PaisMock("Zimbabwe3"));
        paises.add(new PaisMock("República checa3"));
        paises.add(new PaisMock("Noruega4"));
        paises.add(new PaisMock("Zimbabwe4"));
        paises.add(new PaisMock("República checa4"));
        List<Artefacto> artefactos = new ArrayList<Artefacto>();
        artefactos.add(new Artefacto("Las pirámides", new Comun()));
        List<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(new Ladron("Carmen", "Femenino", "Moto", "Marrón", "Bien bonita", "Danza"));
        Robo robo = gRobo.generarRobo(new RangoMock(new Comun()), artefactos, paises, ladrones);
        assertEquals(robo.viaSinInit.size(), 4);
        assertFalse(robo.lugarDeRobo().obtenerAdyacentes().contains(robo.lugarDeRobo()));
        assertEquals(3, robo.lugarDeRobo().obtenerAdyacentes().size());
        assertTrue(paises.containsAll(robo.viaSinInit));
        
    }
}
