package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ComputadoraTest {

    Temporizador t = new Temporizador(0, 20, 48);
    Policia paco = new Policia(new PaisMock("Argentina"), t);

    public ComputadoraTest() throws Exception {
    }

    @Test
    public void CargarDatosYReducirLista() throws Exception {

        int tamanioEsperado = 2;

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "F", "Motocicleta","Negro", "Cicatriz","Musica");

        Computadora computadora = new Computadora();

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco, "", "", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());

    }

    @Test
    public void CargarDatosYEmitirOrdenDeArresto() throws Exception {

        int tamanioEsperado = 1;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Policia paco = new Policia(colombia, t);

        Computadora computadora = new Computadora();

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco,"M", "Deportivo", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(juan.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

    @Test
    public void SeEmiteUnaOrdenDeArrestoParaUnLadronExitosamente() throws Exception {

        int tamanioEsperado = 1;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Policia paco = new Policia(colombia, t);

        Computadora computadora = new Computadora();

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco,"M", "Deportivo", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(juan.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

    @Test
    public void SeObtieneUnaListaReducidaDeSospechososExitosamente() throws Exception {

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
        assertEquals(null, paco.ordenDeArresto);
    }

}