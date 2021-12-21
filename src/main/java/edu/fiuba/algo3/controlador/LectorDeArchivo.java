package edu.fiuba.algo3.controlador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.*;

import edu.fiuba.algo3.modelo.*;



public class LectorDeArchivo {

    public List<IPais> obtenerPaises() throws Exception {
        List<IPais> paises = new ArrayList<>();
        for(int i = 0; i < 23; i++)
            paises.add( new Pais("Francia" + i, 0, 0));
        return paises;
    }

    public List<Artefacto> obtenerArtefactos() throws IOException, ParseException {
        return this.cargarArtefactos();
    }

    private List<Artefacto> cargarArtefactos() throws IOException, ParseException {
        List<Artefacto> artefactos = new ArrayList<>();

        JSONObject parser = (JSONObject) new JSONParser()
                .parse(new FileReader("src/main/resources/edu/fiuba/algo3/tesoros.json"));

        JSONArray tesoros = (JSONArray) parser.get("tesoros");
        tesoros.forEach(entry -> {
            JSONObject project = (JSONObject) entry;

            Valor valor;
            if(project.get("valor").equals("Comun")) valor = new Comun();
            else if (project.get("valor").equals("Valioso")) valor = new Valioso();
            else valor = new MuyValioso();

            artefactos.add(new Artefacto((String)project.get("tesoro"), valor));
        });

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
