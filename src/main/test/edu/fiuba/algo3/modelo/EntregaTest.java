package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

//TODO: artefactos, etc dependen de la dificultad
public class EntregaTest {
    ITemporizador t = new TemporizadorMock();
    @Test
    public void robaronTesoroNacionalEnMontreal() throws Exception { 
        List<IPais> paises = new ArrayList<IPais>();
        //TODO: capitales aun no implementadas. digamos que montreal es un pais
        //TODO: lanzar error si se inicializa robo con <2 paises
        paises.add(new Pais("Montreal", 0, 0));
        paises.add(new Pais("Zimbabwe", 0, 0));
        paises.add(new Pais("Otro", 0, 0));
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Anillo", "Tenis");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises.subList(0,2), paises, carmen, arte);

        Pais montreal = new Pais(elRobo.lugarDeRobo().nombre(), new GeneradorMockDeEdificios(), 0, 0);
        Edificio edificio = new Edificio (
            "aeropuerto", montreal,
                new EstuvoEnEdificio(new PistaDeMoneda("Euro")));
        montreal.agregarEdificios(edificio);
        Policia roberta = new Policia();
        roberta.asignarCaso(montreal, new EstadoDeJuego(),  new TemporizadorMock());
        roberta.entrarA(edificio);
        assertEquals(roberta.cuestionarTestigo(), "Quería cambiar su dinero por Euro.");
    }

    @Test
    public void PoliciaVisitaBancoLuegoBiblioteca() throws Exception { 
        List<IPais> paises = new ArrayList<IPais>();
        paises.add(new Pais("Montreal", 0, 0));
        paises.add(new Pais("Lima", 0, 0));
        paises.add(new Pais("Otro", 0, 0));

        //TODO: usar robo mock en esta seccion

        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Anillo", "Tenis");

        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises.subList(0,2), paises, carmen, arte);

        Pais montreal = new Pais(elRobo.lugarDeRobo().nombre(), 
            new GeneradorMockDeEdificios(), 0, 0);

        Edificio banco = new Edificio (
            "banco", montreal,
            new EstuvoEnEdificio(new PistaDeMoneda("Euro")));

        Edificio biblio = new Edificio (
            "biblioteca", montreal,
            new EstuvoEnEdificio(new PistaDeMoneda("Euro")));
        
        montreal.agregarEdificios(banco, biblio);

        Policia roberta = new Policia();
        roberta.asignarCaso(montreal, new EstadoDeJuego(),  new TemporizadorMock());

        roberta.entrarA(banco);

        assertEquals("Quería cambiar su dinero por Euro.",roberta.cuestionarTestigo());
        roberta.salirDelEdificio();
        roberta.entrarA(biblio);
        assertEquals("Quería cambiar su dinero por Euro.",roberta.cuestionarTestigo());
    }
    
    //Nota: test redundante en PoliciaTest. Puesto aqui por conveniencia
    @Test
    public void viajaDeMontrealAMéxico() throws Exception{
        IPais montreal = new PaisMock("Montreal");
        IPais mexico = new PaisMock("México");
        montreal.conectarA(mexico);
        Policia paco = new Policia();
        paco.asignarCaso(montreal, new EstadoDeJuego(),  new TemporizadorMock());

        assertEquals(montreal.nombre(), paco.paisActual().nombre());
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());
    }
    
    //Nota: test redundante en PoliciaTest. Puesto aqui por conveniencia
    @Test
    public void Entrar3VecesAlAeropuertoY55VecesAlPuerto() throws Exception{
        List<IPais> paises = new ArrayList<IPais>();
        paises.add(new Pais("Montreal", 0, 0));
        paises.add(new Pais("Lima",0,0));
        paises.add(new Pais("Otro",0,0));

        //TODO: usar robo mock en esta seccion
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Anillo", "Tenis");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises.subList(0,2), paises, carmen, arte);

        Pais montreal = new Pais(
            elRobo.lugarDeRobo().nombre(), 
            new GeneradorMockDeEdificios(), 0, 0);

        Edificio banco = new Edificio (
            "aeropuerto", montreal,
            new EstuvoEnEdificio(new PistaDeMoneda("Euro")));
        Edificio biblio = new Edificio (
            "puerto", montreal,
            new EstuvoEnEdificio(new PistaDeMoneda("Dolares")));

        montreal.agregarEdificios(banco, biblio);


        //montreal, t, new EstadoDeJuego()
        Policia roberta = new Policia();
        roberta.asignarCaso(montreal, new EstadoDeJuego(), t);
        for(int i = 0; i < 3; i++){
            roberta.entrarA(banco);
            assertEquals(roberta.cuestionarTestigo(), "Quería cambiar su dinero por Euro.");
            roberta.salirDelEdificio();
        }

        for(int i = 0; i < 55; i++){
            roberta.entrarA(biblio);
            assertEquals(roberta.cuestionarTestigo(), "Quería cambiar su dinero por Dolares.");
            roberta.salirDelEdificio();
        }
    }
    
    //Nota: test redundante en PoliciaTest. Puesto aqui por conveniencia
    @Test
    public void PoliciaEsHeridoConCuchilloYDuerme() throws Exception{
        IPais montreal = new PaisMock("Montreal");
        Temporizador t = new Temporizador(9);
        //montreal, t, new EstadoDeJuego())
        Policia undyne = new Policia();
        undyne.asignarCaso(montreal, new EstadoDeJuego(), t);
        assertEquals(t.horasTranscurridas(), 0);
        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 2); //Herida con un cuchillo:2 hs la primera vez, 1 hs las próximas veces.


        //hacer que pasen 12 horas para que duerma el policia
        for(int i = 0; i < 10; i++)
            undyne.recibirHeridaConCuchillo();

        assertEquals(t.horasTranscurridas(), 12 + 8);
    }
}