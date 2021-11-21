package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PoliciaTest {
    @Test
    public void testCuestionarTestigo() throws Exception {
        Pais pais = new Pais("Colombia");
        Edificio banco = new Edificio("El banco");
        pais.agregarEdificio(banco);

        Policia paco = new Policia(pais);
        assertThrows(Exception.class, () -> paco.cuestionarTestigo());
        paco.entrarA(banco);
        assertEquals("YO NO VI NADA!!!!",paco.cuestionarTestigo());
    }

    @Test
    public void entrarAEdificioQueNoEstaEnPaisCausaExcepcion() throws Exception {
        Pais colombia = new Pais("Colombia");
        Edificio e =  new Edificio("La ferretería");
        Policia paco = new Policia(colombia);
        
        assertThrows(Exception.class, () -> paco.entrarA(e));
    }

    @Test
    public void entrarAEdificio() throws Exception {
        Pais colombia = new Pais("Colombia");
        Edificio e =  new Edificio("La ferretería");
        colombia.agregarEdificio(e);

        Policia paco = new Policia(colombia);
        
        paco.entrarA(e);
        assertThrows(Exception.class, () -> paco.entrarA(new Edificio("Migraciones")));
    }
}