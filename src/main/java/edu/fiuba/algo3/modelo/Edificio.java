package edu.fiuba.algo3.modelo;

public class Edificio {

    int cantidadDeVisitas = 0;

    Pais pais;
    Testigo testigo = new Testigo();
    String nombre;
    //TipoDeEdicio tipoDeEdificio = new TipoDeEdificio();

    public Edificio(String nombre, Pais pais){
        this.pais = pais;
        this.nombre = nombre;
    }
    
    public Testigo obtenerTestigo() {
        return this.testigo;
    }

    public Pais obtenerPais() {
        return this.pais;
    }

    public int cantidadDeVisitas(){
        return this.cantidadDeVisitas;
    }

    public void nuevaVisita(){
        cantidadDeVisitas ++;
    }
}
