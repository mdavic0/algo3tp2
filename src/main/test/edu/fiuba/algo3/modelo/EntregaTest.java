package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

//TODO: artefactos, etc dependen de la dificultad
public class EntregaTest {
    @Test
    public void robaronTesoroNacionalEnMontreal() throws Exception { 
        List<PaisSinPistas> paises = new ArrayList<PaisSinPistas>();
        //TODO: capitales aun no implementadas. digamos que montreal es un pais
        paises.add(new PaisSinPistas("Montreal"));
        //TODO: lanzar error si se inicializa robo con <2 paises
        paises.add(new PaisSinPistas("Zimbabwe"));
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita");
        Artefacto arte = new Artefacto("La pantera rosa");
        Robo elRobo = new Robo(paises, carmen, arte);

        Pais montreal = new Pais(elRobo.lugarDeRobo().nombre, elRobo);
        Edificio edificio = new Edificio("El banco", montreal, elRobo);
        montreal.agregarEdificio(edificio);
        Policia roberta = new Policia(montreal);
        roberta.entrarA(edificio);
    }
    @Test
    public void PoliciaVisitaBancoLuegoBiblioteca() throws Exception { 
        List<PaisSinPistas> paises = new ArrayList<PaisSinPistas>();
        paises.add(new PaisSinPistas("Montreal"));
        paises.add(new PaisSinPistas("Zimbabwe"));

        //TODO: usar robo mock en esta seccion
        Ladron carmen = new Ladron("Carmen Sandiego", "F", "Moto", "Oscuro", "Bien bonita");
        Artefacto arte = new Artefacto("La pantera rosa");
        Robo elRobo = new Robo(paises, carmen, arte);

        Pais montreal = new Pais(elRobo.lugarDeRobo().nombre, elRobo);


        Edificio banco = new Edificio("El banco", montreal, elRobo);
        Edificio biblio = new Edificio("La biblioteca", montreal, elRobo);
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblio);


        Policia roberta = new Policia(montreal);
        roberta.entrarA(banco);
        //roberta.salirDe(banco);
        //roberta.entrarA(biblio);
    }
    
}