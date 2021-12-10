package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test {

    ITemporizador t = new Temporizador(16);

    @Test
    public void PoliciaSufreUnaHeridaDeCuchilloYDuerme() throws Exception {
        IPais montreal = new PaisMock("Montreal");
        Policia undyne = new Policia(montreal, t, new EstadoDeJuego());

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 2); //Herida con un cuchillo:2 hs la primera vez, 1 hs las próximas veces.

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 3);

        undyne.recibirHeridaConCuchillo();
        assertEquals(4 + 8, t.horasTranscurridas());
    }


    @Test
    public void PoliciaConRangoInvestigadorTomaCasoDeUnRoboViajaDeMontrealaMexico() throws Exception {
        Pais montreal = new Pais("Montreal", 0, 0);
        Pais mexico = new Pais("Mexico", 0, 0);
        montreal.conectarA(mexico); // TODO: esto deberia hacerse automagicamente cuando se crea la ruta del ladron

        List<Pais> paises = new ArrayList<Pais>();
        paises.add(montreal);
        paises.add(mexico);

        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises, carmen, arte);

        //Toma caso de un robo se representa como que el Policia respawnea en el pais en el que ocurre el robo
        Policia paco = new Policia(elRobo.lugarDeRobo(), t, new EstadoDeJuego());

        //Se verifica la promocion de rango
        assertEquals(Novato.class, paco.rango.getClass());
        for(int i = 0; i < 10; i++){ paco.arrestarLadron(); }
        assertEquals(Investigador.class, paco.rango.getClass());

        //Viaja de Montreal a Mexico
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());
    }

    @Test
    public void CargarEnLaComputadoraLosDatosRecopiladosYBuscarSospechosos() throws Exception {
        int tamanioEsperado = 2;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica");

        Policia paco = new Policia(colombia, t, new EstadoDeJuego());

        Computadora compu = new Computadora();
        List<Ladron> ladronesObtenidos = compu.consultarDatos(paco, "", "", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());
        assertNull(paco.ordenDeArresto); // Como hay 2 sospechosos NO se emite la orden de arresto
    }

    @Test
    public void IntentaAtraparAlSospechosoSinLaOrdenDeArrestoEmitida() throws Exception {
        IPais colombia = new PaisMock("Colombia");
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis");
        IEdificio e =  new Edificio("El Bar", colombia, new EstaEnElEdificio(carmen));

        colombia.agregarEdificio(e);

        EstadoDeJuego estado = new EstadoDeJuego();
        Policia paco = new Policia(colombia, t, estado);

        assertTrue(estado.juegoEnProgreso());

        paco.entrarA(e);
        assertFalse(estado.juegoEnProgreso());
        assertTrue(estado.juegoPerdido());
    }

    @Test
    public void PartidaCompleta() throws Exception {
        //inicializamos un EstadoDeJuego que se suscribe a entidades que causan fin de juego
        EstadoDeJuego estado = new EstadoDeJuego();

        //Polcia Toma un caso de un sospechoso que robó un Incan Gold Mask
        EdificioMock banco = new EdificioMock("Banco", "Compro una banda de pesos Mexicanos, tenia pelo Oscuro");
        EdificioMock museo = new EdificioMock("Museo", "Esta interesada en cuadros sobre Mariachis, llego en una Moto");
        EdificioMock puerto = new EdificioMock("Puerto", "Se dirigia a un lugar cuya bandera tiene un aguila en el medio, le gusta el tenis");
        Pais peru = new Pais("Peru",new GeneradorMockDeEdificios(banco, museo, puerto), 0, 0);
        banco.setPais(peru);
        museo.setPais(peru);
        puerto.setPais(peru);

        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis");

        Pais mexico = new Pais("Mexico", 0, 0);
        IEdificio biblioteca = new Edificio("Biblioteca", mexico, new EstaEnElEdificioDeAlLado());
        IEdificio  bolsa = new Edificio("Bolsa", mexico, new EstaEnElEdificioDeAlLado());
        IEdificio aeropuerto = new Edificio("Aeropuerto", mexico, new EstaEnElEdificio(carmen));
        mexico.agregarEdificio(biblioteca);
        mexico.agregarEdificio(bolsa);
        mexico.agregarEdificio(aeropuerto);

        peru.conectarA(mexico);

        List<Pais> viaDelLadron = new ArrayList<Pais>();
        viaDelLadron.add(peru);
        viaDelLadron.add(mexico);

        Artefacto mascara = new Artefacto("Incan Gold Mask", new MuyValioso());
        Robo elRobo = new Robo(viaDelLadron, carmen, mascara);

        //Toma caso de un robo se representa como que el Policia respawnea en el pais en el que ocurre el robo
        Policia paco = new Policia(elRobo.lugarDeRobo(), t, estado);

        //El estado de juego se debe suscribir al Policia para ser notificado
        //de una victoria o pérdida.
        //TODO: agregar estado de juego al constructor
        paco.agregarSuscriptor(estado);

        //Un Policia hace 6 Arrestos.  ==> RECIBE PROMOCION de Novato a Detective.
        assertEquals(Novato.class, paco.rango.getClass());
        for(int i = 0; i < 6; i++){ paco.arrestarLadron(); }
        assertEquals(Detective.class, paco.rango.getClass());

        //Realiza la investigación
        paco.entrarA(museo);
        assertEquals("Esta interesada en cuadros sobre Mariachis, llego en una Moto", paco.cuestionarTestigo());
        paco.salirDelEdificio();

        paco.entrarA(banco);
        assertEquals("Compro una banda de pesos Mexicanos, tenia pelo Oscuro", paco.cuestionarTestigo());
        paco.salirDelEdificio();

        paco.entrarA(puerto);
        assertEquals("Se dirigia a un lugar cuya bandera tiene un aguila en el medio, le gusta el tenis", paco.cuestionarTestigo());
        paco.salirDelEdificio();

        //CON ESTAS PISTAS TENEMOS DATOS SUFICIENTES PARA PODER EMITIR UNA ORDEN DE ARRESTO

        Computadora computadora = new Computadora();
        computadora.consultarDatos(paco, "F", "Moto", "Oscuro", "", "tenis");

        //HASTA ACA YA SABEMOS VARIAS PISTAS PARA PODER VIAJAR AL SIGUIENTE PAIS

        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());

        paco.entrarA(biblioteca);
        assertEquals("Cuidado, la persona que buscas esta MUY cerca!!", paco.cuestionarTestigo());
        paco.salirDelEdificio();

        paco.entrarA(bolsa);
        assertEquals("Cuidado, la persona que buscas esta MUY cerca!!", paco.cuestionarTestigo());
        paco.salirDelEdificio();

        assertFalse(estado.juegoGanado());
        assertTrue(estado.juegoEnProgreso());

        paco.entrarA(aeropuerto);
        assertTrue(estado.juegoGanado());
        assertFalse(estado.juegoEnProgreso());
    }

}