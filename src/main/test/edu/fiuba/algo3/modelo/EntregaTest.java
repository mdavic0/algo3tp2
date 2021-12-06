package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

//TODO: artefactos, etc dependen de la dificultad
public class EntregaTest {
    Temporizador t = new Temporizador(0, 20, 48);
    @Test
    public void robaronTesoroNacionalEnMontreal() throws Exception { 
        List<PaisSinPistas> paises = new ArrayList<PaisSinPistas>();
        //TODO: capitales aun no implementadas. digamos que montreal es un pais
        paises.add(new PaisSinPistas("Montreal", "Euro", 0, 0));
        //TODO: lanzar error si se inicializa robo con <2 paises
        paises.add(new PaisSinPistas("Zimbabwe", "Euro", 0, 0));
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises, carmen, arte);

        Pais montreal = new Pais(elRobo.lugarDeRobo().nombre, new GeneradorMockDeEdificios(), 0, 0);
        Edificio edificio = new Edificio (
            "aeropuerto", montreal, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(elRobo), montreal)); 
        montreal.agregarEdificio(edificio);
        Policia roberta = new Policia(montreal, t);
        roberta.entrarA(edificio);
        assertEquals(roberta.cuestionarTestigo(), "Quería cambiar su dinero por");
    }

    @Test
    public void PoliciaVisitaBancoLuegoBiblioteca() throws Exception { 
        List<PaisSinPistas> paises = new ArrayList<PaisSinPistas>();
        paises.add(new PaisSinPistas("Montreal", "Euro", 0, 0));
        paises.add(new PaisSinPistas("Lima", "Euro", 0, 0));

        //TODO: usar robo mock en esta seccion
        Ladron carmen = new Ladron(
            "Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises, carmen, arte);

        Pais montreal = new Pais(elRobo.lugarDeRobo().nombre, 
            new GeneradorMockDeEdificios(), 0, 0);

        Edificio banco = new Edificio (
            "banco", montreal, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(elRobo), montreal)); 
        Edificio biblio = new Edificio (
            "biblioteca", montreal, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(elRobo), montreal)); 
        
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblio);


        Policia roberta = new Policia(montreal, t);

        roberta.entrarA(banco);

        assertEquals("Quería cambiar su dinero por",roberta.cuestionarTestigo());
        roberta.salirDe(banco);
        roberta.entrarA(biblio);
        assertEquals("Quería cambiar su dinero por",roberta.cuestionarTestigo());
    }
    
    //Nota: test redundante en PoliciaTest. Puesto aqui por conveniencia
    @Test
    public void viajaDeMontrealAMéxico() throws Exception{
        IPais montreal = new PaisMock("Montreal");
        IPais mexico = new PaisMock("México");
        montreal.conectarA(mexico);
        Policia paco = new Policia(montreal, t);

        assertEquals(montreal.nombre(), paco.paisActual().toString());
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().toString());
    }
    
    //Nota: test redundante en PoliciaTest. Puesto aqui por conveniencia
    @Test
    public void Entrar3VecesAlAeropuertoY55VecesAlPuerto() throws Exception{
        List<PaisSinPistas> paises = new ArrayList<PaisSinPistas>();
        paises.add(new PaisSinPistas("Montreal", "Euro", 0, 0));
        paises.add(new PaisSinPistas("Lima", "Euro",0,0));

        //TODO: usar robo mock en esta seccion
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises, carmen, arte);

        Pais montreal = new Pais(
            elRobo.lugarDeRobo().nombre, 
            new GeneradorMockDeEdificios(), 0, 0);

        Edificio banco = new Edificio (
            "aeropuerto", montreal, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(elRobo), montreal)); 
        Edificio biblio = new Edificio (
            "puerto", montreal, 
            new DificultadMock(), 
            new Temporizador(0,0,0), 
            new EdificioEconomico(new FabricaDePistas(elRobo), montreal)); 
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblio);


        Policia roberta = new Policia(montreal, t);
        for(int i = 0; i < 3; i++){
            roberta.entrarA(banco);
            assertEquals(roberta.cuestionarTestigo(), "Quería cambiar su dinero por");
            roberta.salirDe(banco);
        }

        for(int i = 0; i < 55; i++){
            roberta.entrarA(biblio);
            assertEquals(roberta.cuestionarTestigo(), "Quería cambiar su dinero por"); 
            roberta.salirDe(biblio); 
        }
    }
    
    //Nota: test redundante en PoliciaTest. Puesto aqui por conveniencia
    @Test
    public void PoliciaEsHeridoConCuchilloYDuerme() throws Exception{
        IPais montreal = new PaisMock("Montreal");
        Temporizador t = new Temporizador(9, 20, 36);
        Policia undyne = new Policia(montreal, t);
        assertEquals(t.horasTranscurridas(), 0);
        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 2); //Herida con un cuchillo:2 hs la primera vez, 1 hs las próximas veces.


        //hacer que pasen 12 horas para que duerma el policia
        for(int i = 0; i < 10; i++)
            undyne.recibirHeridaConCuchillo();

        assertEquals(t.horasTranscurridas(), 12 + 8);
    }
}