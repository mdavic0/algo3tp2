package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Policia implements PropertyChangeListener {

    LugarActual lugarActual;
    //String pista; //idealmente una coleccion
    IRango rango;
    ITemporizador temporizador;
    OrdenDeArresto ordenDeArresto;

    int cantidadArrestos;
    int heridasPorCuchillo;
    int hora_dormir = 20;
    private String estadoDeJuego; //TODO: Reemplazar por sistema de eventos...

    public Policia(IPais pais, ITemporizador temporizador) {
        lugarActual = new FueraDeEdificio(pais);
        rango = new Novato();
        ordenDeArresto = null;
        this.temporizador = temporizador;
        temporizador.agregarSuscriptor(this);
        cantidadArrestos = 0;
        heridasPorCuchillo = 0;
        this.estadoDeJuego = "Estoy investigando...";
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

    public void salirDe(IEdificio edificio) throws Exception {
        this.lugarActual = this.lugarActual.salirDe(edificio);
    }

    public void recibirHeridaConCuchillo() throws Exception {
        heridasPorCuchillo++;
        HeridaConCuchillo actividad = new HeridaConCuchillo(heridasPorCuchillo);
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

    public boolean puedeArrestar(Ladron ladron) {
        if(this.ordenDeArresto != null)
            return this.ordenDeArresto.puedeArrestarA(ladron);
        return false;
    }

    private void dormir(){
        temporizador.reportarActividad(8);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "horaActual" 
            && (int)evt.getNewValue() >= hora_dormir)
            this.dormir();
    }

    public void reportarIngresoAEdificio(EntrarAEdificio entrarAEdificio) {
        entrarAEdificio.reportar(this.temporizador);
    }
}
