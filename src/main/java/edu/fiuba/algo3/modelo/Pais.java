package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Pais { 
    String nombre;
    List<Pais> adyacentes;
    List<Edificio> edificios;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();
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
}
