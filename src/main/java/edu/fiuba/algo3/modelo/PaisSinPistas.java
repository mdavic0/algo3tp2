package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class PaisSinPistas { 
    String nombre;
    String moneda;

    public PaisSinPistas(String nombre, String moneda, double latitud, double longitud) throws Exception{
        this.nombre = nombre;
        this.moneda = moneda;
    }

    public String moneda(){
        return moneda;
    }
}
