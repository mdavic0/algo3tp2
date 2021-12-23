package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Computadora;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ComputadoraTest {

    ITemporizador t = new TemporizadorMock();
    Policia paco = new Policia();

    public ComputadoraTest() throws Exception {
    }

    @Test
    public void CargarDatosYReducirLista() throws Exception {

        int tamanioEsperado = 2;

        Ladron juan = new Ladron ("Juan", "Masculino", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "Femenino", "Motocicleta","Negro", "Cicatriz","Musica");

        Computadora computadora = new Computadora(Arrays.asList(juan, roberta));

        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Cabello", "Negro"));
        propiedades.add(new Propiedad("Senia", "Cicatriz"));
        propiedades.add(new Propiedad("Hobby", "Musica"));

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco, propiedades);

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());

    }

    @Test
    public void CargarDatosYEmitirOrdenDeArresto() throws Exception {

        int tamanioEsperado = 1;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "Masculino", "Deportivo", "Negro", "Cicatriz","Musica");
        Policia paco = new Policia();
        Computadora computadora = new Computadora(Arrays.asList(juan));
        paco.asignarCaso(colombia, new EstadoDeJuego(), new TemporizadorMock(), computadora);



        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Genero", "Masculino"));
        propiedades.add(new Propiedad("Vehiculo", "Deportivo"));
        propiedades.add(new Propiedad("Cabello", "Negro"));

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco, propiedades);

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(juan.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

    @Test
    public void SeEmiteUnaOrdenDeArrestoParaUnLadronExitosamente() throws Exception {

        int tamanioEsperado = 1;

        IPais colombia = new PaisMock("Colombia");

        Ladron juan = new Ladron ("Juan", "Masculino", "Deportivo", "Negro", "Cicatriz","Musica");
        Policia paco = new Policia();
        paco.asignarCaso(colombia, new EstadoDeJuego(), new TemporizadorMock(), new ComputadoraMock());

        Computadora computadora = new Computadora(Arrays.asList(juan));

        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Genero", "Masculino"));
        propiedades.add(new Propiedad("Vehiculo", "Deportivo"));
        propiedades.add(new Propiedad("Cabello", "Negro"));

        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco,propiedades);

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(juan.nombre(), paco.ordenDeArresto.sospechoso().nombre());

    }

    @Test
    public void SeObtieneUnaListaReducidaDeSospechososExitosamente() throws Exception {

        int tamanioEsperado = 2;

        Ladron juan = new Ladron ("Juan", "Masculino", "Deportivo", "Negro", "Cicatriz","Musica");
        Ladron roberta = new Ladron("Roberta Rigoberta", "Femenino", "Motocicleta","Negro", "Cicatriz","Musica");

        Policia paco = new Policia();

        Computadora computadora = new Computadora(Arrays.asList(juan, roberta));

        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Cabello", "Negro"));
        propiedades.add(new Propiedad("Senia", "Cicatriz"));
        propiedades.add(new Propiedad("Hobby", "Musica"));
        List<Ladron> ladronesObtenidos = computadora.consultarDatos(paco, propiedades);

        assertEquals(tamanioEsperado, ladronesObtenidos.size());
        assertEquals(juan.nombre(), ladronesObtenidos.get(0).nombre());
        assertEquals(roberta.nombre(), ladronesObtenidos.get(1).nombre());
        assertNull(paco.ordenDeArresto); // Como hay 2 sospechosos NO se emite la orden de arresto
        //TODO: Que el policia tenga un metodo boolean tieneOrdenDeArresto(); para evitar chequear esto ^^^
    }

}