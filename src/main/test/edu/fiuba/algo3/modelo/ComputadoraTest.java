package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputadoraTest {

    @Test
    public void CargarDatosYReducirLista(){

        Ladron juan = new Ladron ("Juan", "M", "Deportivo", "Negro", "Cicatriz","Musica");
        Computadora computadora = new Computadora();

        Ladron ladronObtenido = computadora.consultarDatos("M", "Deportivo", "Negro", "Cicatriz","Musica").get(0);

        assertEquals(juan, ladronObtenido);

    }

}
