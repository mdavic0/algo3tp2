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
        Policia undyne = new Policia(montreal, t);

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 2); //Herida con un cuchillo:2 hs la primera vez, 1 hs las próximas veces.

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 3);

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 4 + 8);
    }


    @Test
    public void PoliciaConRangoInvestigadorTomaCasoDeUnRoboViajaDeMontrealaMéxico() throws Exception {
        //TODO: Eliminar PaisSinPistas
        List<PaisSinPistas> paises = new ArrayList<PaisSinPistas>();
        paises.add(new PaisSinPistas("Montreal", "Dolar", 0, 0));
        paises.add(new PaisSinPistas("Mexico", "Peso Mexicano", 0, 0));


        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises, carmen, arte);

        //TODO: Toma caso de un robo (? , de momento se representa como que el Policia respawnea en el pais en el que ocurre el robo
        IPais paisOrigen = new Pais(elRobo.lugarDeRobo().nombre, new GeneradorMockDeEdificios(), 0,0);
        IPais mexico = new Pais("Mexico", new GeneradorMockDeEdificios(), 0, 0);
        paisOrigen.conectarA(mexico); // TODO: esto deberia hacerse automagicamente cuando se crea la ruta del ladron

        Policia paco = new Policia(paisOrigen, t);

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

        Policia paco = new Policia(colombia, t);

        Computadora computadora = new Computadora();

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco, "", "", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());
        assertNull(paco.ordenDeArresto); // Como hay 2 sospechosos NO se emite la orden de arresto
    }

    @Test
    public void IntentaAtraparAlSospechosoSinLaOrdenDeArrestoEmitida() throws Exception {
        IPais colombia = new PaisMock("Colombia");
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis");
        IEdificio e =  new Edificio("El Bar", colombia, new DificultadMock(), t, new PistaMock("EL ladron esta aca!"), new EstaEnElEdificio(carmen) );

        colombia.agregarEdificio(e);

        Policia paco = new Policia(colombia, t);

        Computadora computadora = new Computadora();

        //assertEquals("Estoy investigando...", paco.estadoDeJuego());

        paco.entrarA(e);
        //assertEquals("Perdi :(", paco.estadoDeJuego());
    }

    @Test
    public void PartidaCompleta() throws Exception {
        //Polcia Toma un caso de un sospechoso que robó un Incan Gold Mask
        List<PaisSinPistas> viaDelLadron = new ArrayList<PaisSinPistas>();
        viaDelLadron.add(new PaisSinPistas("Peru", "Soles", 0, 0));
        viaDelLadron.add(new PaisSinPistas("Mexico", "Peso Mexicano", 0, 0));

        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita", "tenis");
        Artefacto mascara = new Artefacto("Incan Gold Mask", new MuyValioso());
        Robo elRobo = new Robo(viaDelLadron, carmen, mascara);

        EdificioMock banco = new EdificioMock("Banco", "Compro una banda de pesos Mexicanos, tenia pelo Oscuro");
        EdificioMock museo = new EdificioMock("Museo", "Esta interesada en cuadros sobre Mariachis, llego en una Moto");
        EdificioMock puerto = new EdificioMock("Puerto", "Se dirigia a un lugar cuya bandera tiene un aguila en el medio, le gusta el tenis");

        IPais paisOrigen = new Pais(elRobo.lugarDeRobo().nombre, new GeneradorMockDeEdificios(banco, museo, puerto), 0,0);
        //OBS: de momento "tomar el caso de un robo" significa que el
        // policia respawnea en el pais en el que ocurre el robo
        Policia paco = new Policia(paisOrigen, t);

        //VERIFICAR ESTADO DE JUEGO //TODO: Reemplazar por sistema de eventos...
        //assertEquals("Estoy investigando...", paco.estadoDeJuego());

        banco.setPais(paisOrigen);
        museo.setPais(paisOrigen);
        puerto.setPais(paisOrigen);

        IPais mexico = new Pais("Mexico", new GeneradorMockDeEdificios(), 0,0);
        IPista estaCerca = new PistaMock("Cuidado, el sospechoso que buscas esta cerca!!");
        IPista estaAca = new PistaMock("El sospechoso esta en el edificio!!!");

        IEdificio biblioteca = new Edificio("Biblioteca", mexico, paco.rango.obtenerDificultadPistas(), t, estaCerca, new EstaEnElEdificioDeAlLado());
        IEdificio  bolsa = new Edificio("Bolsa", mexico, paco.rango.obtenerDificultadPistas(), t, estaCerca, new EstaEnElEdificioDeAlLado());
        IEdificio aeropuerto = new Edificio("Aeropuerto", mexico, paco.rango.obtenerDificultadPistas(), t, estaAca, new EstaEnElEdificio(carmen));

        mexico.agregarEdificio(biblioteca);
        mexico.agregarEdificio(bolsa);
        mexico.agregarEdificio(aeropuerto);

        paisOrigen.conectarA(mexico);

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

        assertTrue(paco.puedeArrestar(carmen));

        //HASTA ACA YA SABEMOS VARIAS PISTAS PARA PODER VIAJAR AL SIGUIENTE PAIS

        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());

        paco.entrarA(biblioteca);
        assertEquals(paco.cuestionarTestigo(), "Cuidado, el sospechoso que buscas esta cerca!!");
        paco.salirDelEdificio();

        paco.entrarA(bolsa);
        assertEquals(paco.cuestionarTestigo(), "Cuidado, el sospechoso que buscas esta cerca!!");
        paco.salirDelEdificio();

        // DE MOMENTO SABEMOS QUE ESTA CERCA, VERIFICAMOS ESTADO DE JUEGO
        //assertEquals("Estoy investigando...", paco.estadoDeJuego());

        paco.entrarA(aeropuerto);
        assertEquals("El sospechoso esta en el edificio!!!", paco.cuestionarTestigo());

        // PACO TENIA LA ORDEN DE ARRESTO PARA DETENER A CARMEN ==> GANA
        //assertEquals("Gane loco", paco.estadoDeJuego());
    }

}