package edu.fiuba.algo3.modelo;
import java.util.List;

import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;

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

    public List<IEdificio> edificios() {
        return edificios;
    }

    @Override
    public void agregarEdificios(IEdificio... edificio) {
        for (IEdificio e : edificio) {
            edificios.add(e);
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
        return nombre;
    }

    @Override
    public double obtenerLatitud() {
        return 0;
    }

    @Override
    public double obtenerLongitud() {
        return 0;
    }

    @Override
    public double distanciaA(IPais paisDestino) {
        return 0;
    }

    @Override
    public void agregarEdificios(List<IEdificio> edificios) {
        for (IEdificio e : edificios) {
            edificios.add(e);
            e.asignarPais(this);
        }
    }

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
        return new PistaDeLadron("");
    }

    @Override
    public Pista crearPistaHistorica() {
        return new PistaDeLadron("");
    }

    @Override
    public Pista crearPistaDeViaje() {
        return new PistaDeLadron("");
    }

    @Override
    public List<IPais> obtenerAdyacentes() {
        return adyacentes;
    }

    @Override
    public String descripcion() {
        // TODO Auto-generated method stub
        return null;
    }


}
