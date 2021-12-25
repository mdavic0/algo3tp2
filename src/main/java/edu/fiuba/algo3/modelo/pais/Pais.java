package edu.fiuba.algo3.modelo.pais;
import java.util.List;
import java.util.ArrayList;
import java.util.SplittableRandom;

import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pistas.*;

public class Pais {

    String nombre; //Nombre de la ciudad
    String coloresDeBandera;
    String moneda;
    String geografia;
    String caracteristicas;
    String industrias;
    String animales;
    String etnias;
    String idiomas;
    String arte;
    String religion;
    String representante;
    String datoCurioso;
    String descripcion;

    double latitud;
    double longitud;

    List<Pais> adyacentes;
    List<Edificio> edificios;

    public Pais(String nombre, String coloresDeBandera, String moneda, String geografia, String caracteristicas,
                String industrias, String animales, String etnias, String idiomas, String arte, String religion,
                String representante, String datoCurioso, String descripcion, double latitud, double longitud) {

        this.nombre = nombre;
        this.coloresDeBandera = coloresDeBandera;
        this.moneda = moneda;
        this.geografia = geografia;
        this.caracteristicas = caracteristicas;
        this.industrias = industrias;
        this.animales = animales;
        this.etnias = etnias;
        this.idiomas = idiomas;
        this.arte = arte;
        this.religion = religion;
        this.representante = representante;
        this.datoCurioso = datoCurioso;
        this.descripcion = descripcion;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Pais(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String descripcion(){
        return descripcion.toString();
    }

    public List<Edificio> edificios() {
        return edificios;
    }

    public void agregarEdificios(Edificio... edificios) {
        for (Edificio e : edificios) {
            this.edificios.add(e);
            e.asignarPais(this);
        }
    }

    public void agregarEdificios(List<Edificio> edificios) {
        for (Edificio e : edificios) {
            this.edificios.add(e);
            e.asignarPais(this);
        }
        
    }

    public Boolean contieneEdificio(Edificio edificio) {
        return edificios.contains(edificio);
    }

    public void conectarA(Pais otro) {
        adyacentes.add(otro);
    }

    public boolean sePuedeViajarA(Pais pais) {
        return this.adyacentes.contains(pais); // asume que solo hay una instancia de cada pais
    }


    public String nombre() {
        return this.nombre;
    }

    public double obtenerLatitud() {
        return this.latitud;
    }

    public double obtenerLongitud() {
        return this.longitud;
    }

    public double distanciaA(Pais paisDestino) { // luego se puede cambiar por alguna libreria especifica (GeoCalc)
        double radioTerrestre = 6372.7954;
        double dLat = Math.toRadians(paisDestino.obtenerLatitud() - this.latitud);
        double dLon = Math.toRadians(paisDestino.obtenerLongitud() - this.longitud);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLon / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians( this.latitud)) * Math.cos(Math.toRadians(paisDestino.obtenerLatitud()));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return radioTerrestre * c;
    }

    public Pista crearPistaEconomica() {
        SplittableRandom aleatorio = new SplittableRandom();
        int n = aleatorio.nextInt(1, 101); //crea numero entre 1 y 101

        //33% de probabilidad de que la pista economica sea sobre
        if(n < 33) return new PistaDeIndustria(this.industrias);
        if(n < 66) return new PistaDeRepresentante(this.representante);

        return new PistaDeMoneda(this.moneda); //==>33 % de que genere una pista de moneda
    }

    public Pista crearPistaHistorica() {
        SplittableRandom aleatorio = new SplittableRandom();
        int n = aleatorio.nextInt(1, 101); //crea numero entre 1 y 101

        //20% de probabilidad de que la pista historica sea sobre
        if(n < 20) return new PistaDeArte(this.arte);
        if(n < 40) return new PistaGeografica(this.geografia);
        if(n < 60) return new PistaDeEtnia(this.etnias);
        if(n < 80) return new PistaDeFauna(this.animales);

        return new PistaDeReligion(this.religion); //==>20 % de que genere una pista de religion
    }

    public Pista crearPistaDeViaje() {
        SplittableRandom aleatorio = new SplittableRandom();
        int n = aleatorio.nextInt(1, 101); //crea numero entre 1 y 101

        //20% de probabilidad de que la pista de viaje sea sobre
        if(n < 20 ) return new PistaGeografica(this.geografia);
        if(n < 40) return new PistaDeIdioma(this.idiomas);
        if(n < 60) return new PistaDeDatoCurioso(this.datoCurioso);
        if(n < 80) return new PistaDeRepresentante(this.representante);

        return new PistaDeBandera(this.coloresDeBandera); //==>20 % de que genere una pista de bandera
    }

    public List<Pais> obtenerAdyacentes() {
        return adyacentes;
    }

}
