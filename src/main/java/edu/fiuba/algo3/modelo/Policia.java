package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Policia implements PropertyChangeListener {

    LugarActual lugarActual;
    //String pista; //idealmente una coleccion
    IRango rango;
    ITemporizador temporizador;
    OrdenDeArresto ordenDeArresto;
    int heridasPorCuchillo;

    int cantidadArrestos;
    int hora_dormir = 20;
    
    List<PropertyChangeListener> suscriptores = new ArrayList<PropertyChangeListener>();
    public Policia() {
        lugarActual = new Inactivo();
        rango = new Novato();
        ordenDeArresto = null;
        cantidadArrestos = 0;
    }

    public IRango obtenerRango(){
        return rango;
    }
    public String imprimirRango() {
        return rango.getClass().getName();
    }
    /*
    Ubicar al policia en el juego tras generar el robo
    */
    public void asignarCaso(IPais pais, EstadoDeJuego estado, ITemporizador temporizador){
        lugarActual = new FueraDeEdificio(pais);
        ordenDeArresto = null;
        temporizador.agregarSuscriptor(this);
        this.agregarSuscriptor(estado);
        heridasPorCuchillo = 0;
        this.temporizador = temporizador;
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

    public void recibirHeridaConCuchillo() {
        heridasPorCuchillo++;
        HeridaConCuchillo actividad = new HeridaConCuchillo(heridasPorCuchillo);
        actividad.reportar(this.temporizador);
    }

    public void recibirHeridaConArmaDeFuego() {
        HeridaConArmaDeFuego actividad = new HeridaConArmaDeFuego();
        actividad.reportar(this.temporizador);
    }

    public void emitirOrdenDeArresto(OrdenDeArresto ordenDeArresto) {
        EmitirOrdenDeArresto actividad = new EmitirOrdenDeArresto();
        actividad.reportar(this.temporizador);
        this.ordenDeArresto = ordenDeArresto;
    }

    public void arrestarLadron(){
        cantidadArrestos++;
        rango = this.rango.subirRango(this.cantidadArrestos);
    }

    private boolean puedeArrestar(Ladron ladron) {
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

    public void intentarArrestar(Ladron ladron) {
        if(this.puedeArrestar(ladron))
            notificarSuscriptores(
                new PropertyChangeEvent(this, "Arresto", cantidadArrestos, ++cantidadArrestos));
        else notificarSuscriptores(
            new PropertyChangeEvent(this, "FalloArresto", cantidadArrestos, cantidadArrestos));
    }

    private void notificarSuscriptores(PropertyChangeEvent propertyChangeEvent) {
        for(PropertyChangeListener suscriptor : suscriptores) {
            suscriptor.propertyChange(propertyChangeEvent);
        }
    }

    public void agregarSuscriptor(PropertyChangeListener suscriptor){
        suscriptores.add(suscriptor);
    }
    public void reportarIngresoAEdificio(EntrarAEdificio entrarAEdificio) {
        entrarAEdificio.reportar(this.temporizador);
    }
}
