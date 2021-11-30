package edu.fiuba.algo3.modelo;

public class Edificio {

    int cantidadDeVisitas = 0;

    Pais pais;
    Testigo testigo = new Testigo();
    String nombre;
    TipoDeEdificio tipoDeEdificio;

    public Edificio(String nombre, Pais pais, TipoDeEdificio unTipo){
        this.pais = pais;
        this.nombre = nombre;
        this.tipoDeEdificio = unTipo;
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

    public String seleccionarPista (){
        return tipoDeEdificio.seleccionarPista();
    }
}
