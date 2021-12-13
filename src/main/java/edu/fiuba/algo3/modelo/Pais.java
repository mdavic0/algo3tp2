package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Pais implements IPais { 
    String nombre;
    List<IPais> adyacentes;
    List<IEdificio> edificios;
    double latitud;
    double longitud;
    /*
    public Pais(String nombre, IGeneradorDeEdificios g, double latitud, double longitud, IRango r) throws Exception {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<IPais>();
        this.edificios = new ArrayList<IEdificio>();
        this.edificios.addAll(g.crearEdificiosPara(this, r.obtenerDificultadPistas()));
        this.latitud = latitud;
        this.longitud = longitud;
    }*/
    
    public Pais(String nombre, IGeneradorDeEdificios g, double latitud, double longitud) throws Exception {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<IPais>();
        this.edificios = new ArrayList<IEdificio>();
        this.edificios.addAll(g.crearEdificiosPara(this));
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Pais(String nombre, double latitud, double longitud) throws Exception{
        this.nombre = nombre;
        this.adyacentes = new ArrayList<IPais>();
        this.edificios = new ArrayList<IEdificio>();
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public List<IEdificio> edificios() {
        return edificios;
    }

    @Override
    public void agregarEdificios(IEdificio... edificios) {
        for (IEdificio e : edificios) {
            this.edificios.add(e);
            e.asignarPais(this);
        }
    }

    @Override
    public void agregarEdificios(List<IEdificio> edificios) {
        for (IEdificio e : edificios) {
            this.edificios.add(e);
            e.asignarPais(this);
        }
        
    }
    
    public Boolean contieneEdificio(IEdificio edificio) {
        return edificios.contains(edificio);
    }

    public void conectarA(IPais otro) {
        adyacentes.add(otro);
    }

    public boolean sePuedeViajarA(IPais pais) {
        return this.adyacentes.contains(pais); // asume que solo hay una instancia de cada pais
    }


    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public double obtenerLatitud() {
        return this.latitud;
    }

    @Override
    public double obtenerLongitud() {
        return this.longitud;
    }

    public double distanciaA(IPais paisDestino) { // luego se puede cambiar por alguna libreria especifica (GeoCalc)
        double radioTerrestre = 6372.7954;
        double dLat = Math.toRadians(paisDestino.obtenerLatitud() - this.latitud);
        double dLon = Math.toRadians(paisDestino.obtenerLongitud() - this.longitud);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLon / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians( this.latitud)) * Math.cos(Math.toRadians(paisDestino.obtenerLatitud()));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = radioTerrestre * c;

        return dist;
    }


    //public PaisSinPistas sinPistas() throws Exception {return new PaisSinPistas(this.nombre(), "Euro", latitud, longitud);}

    @Override
    public String moneda() {
        return "Euro";
    }

    //public Object hechoHistorico() {return "Este pais fue invadido por Inglaterra!";}
}
