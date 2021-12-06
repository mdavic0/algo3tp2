package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    String nombre;
    TipoDeEdificio tipoDeEdificio;
    Temporizador temporizador;

    public Edificio(String nombre, IPais pais, Dificultad dificultad, Temporizador temporizador, TipoDeEdificio edificio){
        this.pais = pais;
        this.nombre = nombre;
        this.tipoDeEdificio = edificio; //necesita el pais siguiente si es una pista de pais
        this.temporizador = temporizador;
    }

    public String obtenerTestimonio() {
        return this.tipoDeEdificio.obtenerTestimonio();
    }

    public IPais obtenerPais() {
        return this.pais;
    }

    public Integer cantidadDeVisitas(){
        return this.cantidadDeVisitas;
    }

    public String nombre(){
        return nombre;
    }

    @Override
    public void entrar() { //TODO recibir como parametro al policia
        //if(me da la gana())
        //    paco.heridaDeCuchillo
        cantidadDeVisitas ++;
        this.temporizador.reportarActividad(new EntrarAEdificio(cantidadDeVisitas));
    }
}
