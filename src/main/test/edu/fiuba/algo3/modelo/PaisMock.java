package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class PaisMock implements IPais { 
    String nombre;
    List<IPais> adyacentes;
    List<IEdificio> edificios;

    public PaisMock(String nombre) throws Exception{
        this.nombre = nombre;
        this.adyacentes = new ArrayList<IPais>();
        this.edificios = new ArrayList<IEdificio>();
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

    @Override
    public int obtenerCoordenadaX() {
        return 0;
    }

    @Override
    public int obtenerCoordenadaY() {
        return 0;
    }

    @Override
    public int distanciaA(IPais paisDestino) {
        return 0;
    }
}
