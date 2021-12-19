package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

//TODO: aun no lee paises. Estan hardcodeados
public class LectorDeArchivo {

    public List<IPais> obtenerPaises() throws Exception {
        List<IPais> paises = new ArrayList<>();
        for(int i = 0; i < 23; i++)
            paises.add( new Pais("Francia" + i, 0, 0));
        return paises;
    }
    public List<Artefacto> obtenerArtefactos() {
        List<Artefacto> artefactos = new ArrayList<>();
        Valor[] valores = {new Comun(), new Valioso(), new MuyValioso()};

        for(int j = 0; j < 3; j++) {
            Valor actual = valores[j];
            for(int i = 0; i < 20; i++) {
                artefactos.add(new Artefacto("La torre eiffel", actual));
            }
        }
        return artefactos;
    }
    public List<Ladron> obtenerLadrones() throws Exception{
        List<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(new Ladron("Pedro", "M", "Scooter", "Rubio", "Anillo", "Tenis"));
        ladrones.add(new Ladron("Pedro2", "M", "Scooter", "Rubio", "Anillo", "Tenis"));
        ladrones.add(new Ladron("Pedro3", "M", "Scooter", "Rubio", "Anillo", "Tenis"));
        ladrones.add(new Ladron("Pedro4", "M", "Scooter", "Rubio", "Anillo", "Tenis"));
        ladrones.add(new Ladron("Pedro5", "M", "Scooter", "Rubio", "Anillo", "Tenis"));
        ladrones.add(new Ladron("Carmen", "F", "Moto", "Marrón", "Tatuaje", "Alpinismo"));
        return ladrones;
    }

}
