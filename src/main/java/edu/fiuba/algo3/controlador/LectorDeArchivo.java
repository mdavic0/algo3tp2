package edu.fiuba.algo3.controlador;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.*;


public class LectorDeArchivo {

    public List<Pais> obtenerPaises() throws IOException, ParseException {
        return this.cargarPaises();
    }

    private List<Pais> cargarPaises() throws IOException, ParseException {
        List<Pais> paises = new ArrayList<>();

        JSONObject parser = (JSONObject) new JSONParser()
                .parse(new FileReader("src/main/resources/edu/fiuba/algo3/ciudadesSinTerminar.json"));

        JSONArray ciudades = (JSONArray) parser.get("ciudades");
        ciudades.forEach(entry -> {
            JSONObject project = (JSONObject) entry;

            String lat = project.get("latitud").toString();
            String lon = project.get("longitud").toString();

            double latitud = Double.parseDouble(lat);
            double longitud = Double.parseDouble(lon);

            paises.add(new Pais(project.get("ciudad").toString(), (String)project.get("colorBandera"), (String)project.get("moneda"), (String)project.get("geografia"), (String)project.get("caracteristicas"),
                    (String)project.get("industrias"), (String)project.get("animales"), (String)project.get("etnias"), (String)project.get("idiomas"), (String)project.get("arte"), (String)project.get("religion"), (String)project.get("representante"),
                    (String)project.get("otros"), (String)project.get("descripcion"), latitud, longitud));
        });

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
                .parse(new FileReader("src/main/resources/edu/fiuba/algo3/dossiersGenericos.json"));

        JSONObject parserDetalle = (JSONObject) new JSONParser()
                .parse(new FileReader("src/main/resources/edu/fiuba/algo3/dossiers.json"));

        JSONArray dossiers = (JSONArray) parserDetalle.get("dossiers");
        JSONArray dossiersGenericos = (JSONArray) parser.get("dossiers");
        
        for(int i = 0; i < dossiers.size(); i++){
            JSONObject gen = (JSONObject)dossiersGenericos.get(i);
            JSONObject detalle = (JSONObject)dossiers.get(i);
            Ladron ladron = new Ladron(
                (String )gen.get("nombre"), 
                (String )gen.get("genero"), 
                (String )gen.get("vehiculo"), 
                (String )gen.get("cabello"), 
                (String )gen.get("senia"), 
                (String )gen.get("hobby"));
            
            ladron.definirComoImprimir(
                (String) detalle.get("vehiculo"), 
                (String) detalle.get("cabello"),
                (String) detalle.get("senia"), 
                (String) detalle.get("hobby"));

            ladrones.add(ladron);
        }

        return ladrones;
    }


}
