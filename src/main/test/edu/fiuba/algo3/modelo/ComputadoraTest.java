package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ComputadoraTest {

    Temporizador t = new Temporizador(0, 20, 48);

    @Test
    public void CargarDatosYReducirLista() throws Exception {

        int tamanioEsperado = 2;

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica");

        Computadora computadora = new Computadora();

        ArrayList<Ladron> ladronesObtenidos = computadora.consultarDatos("", "", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());

    }

    @Test
    public void CargarDatosYEmitirOrdenDeArresto() throws Exception {

        int tamanioEsperado = 1;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Policia paco = new Policia(colombia, t, juan);

        Computadora computadora = new Computadora();

        ArrayList<Ladron> ladronesObtenidos = computadora.consultarDatos("M", "Deportivo", "Negro", "Cicatriz","Musica");

        paco.emitirOrdenDeArrestoPara(ladronesObtenidos.get(0));

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(juan.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

    @Test
    public void ArrestarAlLadronExitosamente() throws Exception {

        int tamanioEsperado = 1;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Policia paco = new Policia(colombia, t, juan);

        Computadora computadora = new Computadora();

        ArrayList<Ladron> ladronesObtenidos = computadora.consultarDatos("M", "Deportivo", "Negro", "Cicatriz","Musica");

        paco.emitirOrdenDeArrestoPara(ladronesObtenidos.get(0));
        paco.intentarArrestarLadron();

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(juan.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

    @Test
    public void NoLograrArrestarAlLadron() throws Exception {

        int tamanioEsperado = 2;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica");

        Policia paco = new Policia(colombia, t, juan);

        Computadora computadora = new Computadora();

        ArrayList<Ladron> ladronesObtenidos = computadora.consultarDatos("", "", "Negro", "Cicatriz","Musica");

        paco.emitirOrdenDeArrestoPara(ladronesObtenidos.get(1));
        paco.intentarArrestarLadron();

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());
        assertEquals(roberta.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

}