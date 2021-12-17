package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class Pais implements IPais { 
    String nombre;
    List<IPais> adyacentes;
    List<IEdificio> edificios;
    double latitud;
    double longitud;

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

    //TODO: PAIS SE INICIALIZA CON SUS CARACTERISTICAS (BANDERA, HECHO HISTORICO, CONTINENTE, MONEDA, ETC...) {SE LEE DE LOS JSON}

    private String moneda() {
        return "";
    }

    private String hechoHistorico() {
        return "";
    }

    private String coloresDeBandera() {
        return "";
    }

    private String continente() {
        return "";
    }

    private String idioma() {
        return "";
    }

    @Override
    public Pista crearPistaEconomica() {
        return new PistaDeMoneda(this.moneda());
    }

    @Override
    public Pista crearPistaHistorica() {
        return new PistaHistorica(this.hechoHistorico());
    }

    @Override
    public Pista crearPistaDeViaje() {
        SplittableRandom aleatorio = new SplittableRandom();
        int n = aleatorio.nextInt(1, 101); //crea numero entre 1 y 101

        //33% de probabilidad de que la pista de viaje sea sobre (bandera, continente o idioma)
        if(n <= 33 ) return new PistaDeContinente(this.continente());
        if(n <= 66) return new PistaDeIdioma(this.idioma());

        return new PistaDeBandera(this.coloresDeBandera()); //==> 45% de que genere una pista de bandera
    }

}
