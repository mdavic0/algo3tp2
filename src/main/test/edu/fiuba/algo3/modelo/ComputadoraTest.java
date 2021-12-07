package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ComputadoraTest {

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

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");

        Computadora computadora = new Computadora();

        ArrayList<Ladron> ladronesObtenidos = computadora.consultarDatos("M", "Deportivo", "Negro", "Cicatriz","Musica");

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());

    }

}
