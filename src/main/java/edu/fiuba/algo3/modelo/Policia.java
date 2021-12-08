package edu.fiuba.algo3.modelo;

import java.util.List;

public class Policia {

    LugarActual lugarActual;
    //String pista; //idealmente una coleccion
    IRango rango;
    ITemporizador temporizador;
    OrdenDeArresto ordenDeArresto;

    int cantidadArrestos;
    int heridasPorCuchillo;

    public Policia(IPais pais, ITemporizador temporizador) {
        lugarActual = new FueraDeEdificio(pais);
        rango = new Novato();
        ordenDeArresto = null;
        this.temporizador = temporizador;
        cantidadArrestos = 0;
        heridasPorCuchillo = 0;
    }

    public void salirDelEdificio() throws Exception{
        this.lugarActual = this.lugarActual.salirDelEdificio();
    }

    public void entrarA(IEdificio edificio) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(edificio, this);
    }

    public String cuestionarTestigo() throws Exception {
        return this.lugarActual.cuestionarTestigo();
    }

    public void viajarA(IPais paisDestino) throws Exception {
        lugarActual = this.lugarActual.viajarA(paisDestino);
        this.rango.reportarViaje(this.paisActual(), paisDestino, this.temporizador);
    }

    public IPais paisActual() {
        return this.lugarActual.obtenerPais();
    }

    public void salirDe(Edificio edificio) throws Exception {
        this.lugarActual = this.lugarActual.salirDe(edificio);
    }

    public void recibirHeridaConCuchillo() throws Exception {
        HeridaConCuchillo actividad = new HeridaConCuchillo(heridasPorCuchillo++);
        actividad.reportar(this.temporizador);
    }

    public void recibirHeridaConArmaDeFuego() throws Exception {
        HeridaConArmaDeFuego actividad = new HeridaConArmaDeFuego();
        actividad.reportar(this.temporizador);
    }

    public void emitirOrdenDeArresto(OrdenDeArresto ordenDeArresto) throws Exception {
        EmitirOrdenDeArresto actividad = new EmitirOrdenDeArresto();
        actividad.reportar(this.temporizador);
        this.ordenDeArresto = ordenDeArresto;
    }

    public void arrestarLadron(){
        cantidadArrestos++;
        rango = this.rango.subirRango(this.cantidadArrestos);
    }
}
