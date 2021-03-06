package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.EstaEnElEdificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.EstaEnElEdificioDeAlLado;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Computadora;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.policia.rangos.Detective;
import edu.fiuba.algo3.modelo.policia.rangos.Investigador;
import edu.fiuba.algo3.modelo.policia.rangos.Novato;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;
import edu.fiuba.algo3.modelo.robo.Robo;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test {
    int horaInicial = 16;
    int horaDormir = 20;
    int duracionSueño = 8;
    Temporizador t = new Temporizador(horaInicial, horaDormir);

    @Test
    public void PoliciaSufreUnaHeridaDeCuchilloYDuerme() throws Exception {
        Pais montreal = new PaisMock("Montreal");
        Policia undyne = new Policia();
        undyne.asignarCaso(montreal, new EstadoDeJuego(),t, new ComputadoraMock());

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 2); //Herida con un cuchillo:2 hs la primera vez, 1 hs las próximas veces.

        undyne.recibirHeridaConCuchillo();
        assertEquals(t.horasTranscurridas(), 3);

        undyne.recibirHeridaConCuchillo();
        assertEquals(4 + duracionSueño, t.horasTranscurridas());
    }


    @Test
    public void PoliciaConRangoInvestigadorTomaCasoDeUnRoboViajaDeMontrealaMexico() throws Exception {
        Pais montreal = new Pais("Montreal", 0, 0);
        Pais mexico = new Pais("Mexico", 0, 0);
        Pais austria = new Pais("Austria", 0, 0);
        montreal.conectarA(mexico); // TODO: esto deberia hacerse automagicamente cuando se crea la ruta del ladron

        List<Pais> paises = new ArrayList<Pais>();
        paises.add(montreal);
        paises.add(mexico);
        paises.add(austria);
        paises.add(new Pais("Austria", 0, 0));
        paises.add(new Pais("Austria", 0, 0));
        paises.add(new Pais("Austria", 0, 0));
        paises.add(new Pais("Austria", 0, 0));
        paises.add(new Pais("Austria", 0, 0));
        paises.add(new Pais("Austria", 0, 0));

        Ladron carmen = new Ladron("Carmen Sandiego", "Femenino", "Moto", "Oscuro", "Bien bonita", "tenis");
        Artefacto arte = new Artefacto("La pantera rosa", new Valioso());
        Robo elRobo = new Robo(paises.subList(0,2), paises, carmen, arte);

        //Toma caso de un robo se representa como que el Policia respawnea en el pais en el que ocurre el robo
        Policia paco = new Policia();
        paco.asignarCaso(elRobo.lugarDeRobo(), new EstadoDeJuego(), t, new ComputadoraMock());

        //Se verifica la promocion de rango
        assertEquals(Novato.class, paco.obtenerRango().getClass());
        for(int i = 0; i < 10; i++){ paco.arrestarLadron(); }
        assertEquals(Investigador.class, paco.obtenerRango().getClass());

        //Viaja de Montreal a Mexico
        paco.viajarA(mexico);
        assertEquals(mexico.nombre(), paco.paisActual().nombre());
    }

    @Test
    public void CargarEnLaComputadoraLosDatosRecopiladosYBuscarSospechosos() throws Exception {
        int tamanioEsperado = 2;

        Pais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "Masculino", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "Femenino", "Motocicleta","Negro", "Cicatriz","Musica");

        Policia paco = new Policia();
        Computadora compu = new Computadora(Arrays.asList(juan, roberta));
        paco.asignarCaso(colombia, new EstadoDeJuego(), t, compu);

        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Cabello", "Negro"));
        propiedades.add(new Propiedad("Senia", "Cicatriz"));
        propiedades.add(new Propiedad("Hobby", "Musica"));

        List<Ladron> ladronesObtenidos = compu.consultarDatos(paco, propiedades);

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());
        }

    @Test
    public void IntentaAtraparAlSospechosoSinLaOrdenDeArrestoEmitida() throws Exception {
        Pais colombia = new PaisMock("Colombia");
        Ladron carmen = new Ladron("Carmen Sandiego", "Femenino", "Moto", "Oscuro", "Bien bonita", "tenis");
        Edificio e =  new Edificio("El Bar", colombia, new EstaEnElEdificio(carmen));

        colombia.agregarEdificios(e);

        EstadoDeJuego estado = new EstadoDeJuego();
        Policia paco = new Policia();
        paco.asignarCaso(colombia,estado,t, new ComputadoraMock());

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

        Pais peru = new Pais("Peru",0, 0);
        peru.agregarEdificios(banco, museo, puerto);

        Ladron carmen = new Ladron("Carmen Sandiego", "Femenino", "Moto", "Oscuro", "Bien bonita", "tenis");

        Pais mexico = new Pais("Mexico", 0, 0);
        Edificio biblioteca = new Edificio("Biblioteca", mexico, new EstaEnElEdificioDeAlLado());
        Edificio  bolsa = new Edificio("Bolsa", mexico, new EstaEnElEdificioDeAlLado());
        Edificio aeropuerto = new Edificio("Aeropuerto", mexico, new EstaEnElEdificio(carmen));
        mexico.agregarEdificios(biblioteca, bolsa, aeropuerto);

        peru.conectarA(mexico);

        List<Pais> paises = new ArrayList<Pais>();
        paises.add(peru);
        paises.add(mexico);
        paises.add(new PaisMock("Venezuela"));
        paises.add(new PaisMock("Venezuela"));
        paises.add(new PaisMock("Venezuela"));
        paises.add(new PaisMock("Venezuela"));

        Artefacto mascara = new Artefacto("Incan Gold Mask", new MuyValioso());
        Robo elRobo = new Robo(paises.subList(0, 2), paises,  carmen, mascara);

        //Toma caso de un robo se representa como que el Policia respawnea en el pais en el que ocurre el robo
        Policia paco = new Policia();

        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(carmen);
        paco.asignarCaso(elRobo.lugarDeRobo(), estado,t, new Computadora(ladrones));

        //El estado de juego se debe suscribir al Policia para ser notificado
        //de una victoria o pérdida.
        //TODO: agregar estado de juego al constructor
        paco.agregarSuscriptor(estado);

        //Un Policia hace 6 Arrestos.  ==> RECIBE PROMOCION de Novato a Detective.
        assertEquals(Novato.class, paco.obtenerRango().getClass());
        for(int i = 0; i < 6; i++){ paco.arrestarLadron(); }
        assertEquals(Detective.class, paco.obtenerRango().getClass());

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
        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Cabello", "Oscuro"));
        propiedades.add(new Propiedad("Genero", "Femenino"));
        propiedades.add(new Propiedad("Hobby", "tenis"));
        paco.consultarDatos(propiedades);

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
        assertFalse(estado.juegoEnProgreso());
        assertTrue(estado.juegoGanado());
        
    }

}