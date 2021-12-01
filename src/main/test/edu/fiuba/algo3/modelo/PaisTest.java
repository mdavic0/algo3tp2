package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//mover tests en policia test sobre paisesacá
public class PaisTest {
    @Test
    public void testPaisVieneCon3EdificiosAutomaticamente() throws Exception { 
        Pais p = new Pais("Mexico");

        assertEquals(p.edificios.size(), 3);
        assertEquals(p.edificios.get(0).nombre, "Edificio0");
    }
}