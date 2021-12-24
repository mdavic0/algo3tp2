package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

//mover tests en policia test sobre paises acá
public class LadronTest {
    @Test
    public void leerMultiplesPropiedades() throws Exception {
        Ladron l = new Ladron("Pedro", "Masculino", "Moto", "Rojizo", "Senia1;Senia2", "Diversion1;Diversion2");
        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        propiedades.add(new Propiedad("Senia", "Senia1;Senia2"));
        assertFalse(l.coincideConPropiedades(propiedades));
        
        propiedades.clear();
        propiedades.add(new Propiedad("Senia", "Senia1"));
        assertTrue(l.coincideConPropiedades(propiedades));
        propiedades.add(new Propiedad("Senia", "Senia2"));
        assertTrue(l.coincideConPropiedades(propiedades));
    }
}