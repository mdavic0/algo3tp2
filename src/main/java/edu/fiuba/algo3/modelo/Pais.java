package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Pais implements IPais { 
    String nombre;
    List<IPais> adyacentes;
    List<IEdificio> edificios;
    int coordenadaX;
    int coordenadaY;

    public Pais(String nombre, IRobo robo, int coordenadaX, int coordenadaY) throws Exception{
        this.nombre = nombre;
        this.adyacentes = new ArrayList<IPais>();
        this.edificios = new ArrayList<IEdificio>();
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;

        GeneradorDeEdificios g = new GeneradorDeEdificios(robo);
        this.edificios.addAll(g.crearEdificiosPara(this));
    }
    
    public Pais(String nombre, GeneradorDeEdificios g, int coordenadaX, int coordenadaY) throws Exception {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<IPais>();
        this.edificios = new ArrayList<IEdificio>();
        this.edificios.addAll(g.crearEdificiosPara(this));
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public List<IEdificio> edificios(IEdificio edificio) {
        return edificios;
    }

    public void agregarEdificio(IEdificio edificio) {
        edificios.add(edificio);
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
    
    public String toString(){
        return this.nombre;
    }

    @Override
    public Object nombre() {
        return nombre;
    }

    public int distanciaA(Pais paisDestino) {
        return this.coordenadaX + paisDestino.coordenadaX; //geoCalc
    }
}
