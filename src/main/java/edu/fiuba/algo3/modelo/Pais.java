package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Pais { 
    String nombre;
    List<Pais> adyacentes;
    List<Edificio> edificios;

    public Pais(String nombre) throws Exception{
        this.nombre = nombre;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();
    }

    public Pais(String nombre, Robo robo) throws Exception{
        this.nombre = nombre;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();

        GeneradorDeEdificios g = new GeneradorDeEdificios(robo);
        this.edificios.addAll(g.crearEdificiosPara(this));
    }
    
    public Pais(String nombre, GeneradorDeEdificios g) throws Exception {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();
        this.edificios.addAll(g.crearEdificiosPara(this));
    }

    public List<Edificio> edificios(Edificio edificio) {
        return edificios;
    }

    public void agregarEdificio(Edificio edificio) {
        edificios.add(edificio);
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

    public boolean sos(Pais pais){
        return equals(pais); // asume que solo hay una instancia de cada pais
    }
    
    public String toString(){
        return this.nombre;
    }
}
