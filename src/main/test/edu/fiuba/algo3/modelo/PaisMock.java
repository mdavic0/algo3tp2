package edu.fiuba.algo3.modelo;
import java.util.List;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.pistas.PistaDeLadron;

import java.util.ArrayList;

public class PaisMock extends Pais {
    String nombre;
    List<Pais> adyacentes;
    List<Edificio> edificios;

    public PaisMock(String nombre) throws Exception{
        super(nombre, 0,0);
        this.nombre = nombre;
        this.adyacentes = new ArrayList<Pais>();
        this.edificios = new ArrayList<Edificio>();
    }

    public List<Edificio> edificios() {
        return edificios;
    }

    @Override
    public void agregarEdificios(Edificio... edificio) {
        for (Edificio e : edificio) {
            edificios.add(e);
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
    public double distanciaA(Pais paisDestino) {
        return 0;
    }

    @Override
    public void agregarEdificios(List<Edificio> edificios) {
        /*for (Edificio e : edificios) {
            edificios.add(e);
            e.asignarPais(this);
        }*/
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
    public List<Pais> obtenerAdyacentes() {
        return adyacentes;
    }

    @Override
    public String descripcion() {
        // TODO Auto-generated method stub
        return null;
    }


}
