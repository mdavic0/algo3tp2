package edu.fiuba.algo3.modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.*;



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
        return this.cargarLadrones();
    }

    private List<Ladron> cargarLadrones() throws IOException, ParseException {
        List<Ladron> ladrones = new ArrayList<>();

        JSONObject parser = (JSONObject) new JSONParser()
                .parse(new FileReader("src/main/resources/edu/fiuba/algo3/dossiers.json"));

        JSONArray dossiers = (JSONArray) parser.get("dossiers");
        dossiers.forEach(entry -> {
            JSONObject project = (JSONObject) entry;
            ladrones.add(new Ladron((String )project.get("nombre"), (String )project.get("genero"), (String )project.get("vehiculo"), (String )project.get("cabello"), (String )project.get("senia"), (String )project.get("hobby")));
        });

        return ladrones;
    }


}
