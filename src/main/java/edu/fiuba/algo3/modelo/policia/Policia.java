package edu.fiuba.algo3.modelo.policia;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.actividades.EmitirOrdenDeArresto;
import edu.fiuba.algo3.modelo.actividades.EntrarAEdificio;
import edu.fiuba.algo3.modelo.actividades.HeridaConArmaDeFuego;
import edu.fiuba.algo3.modelo.actividades.HeridaConCuchillo;
import edu.fiuba.algo3.modelo.interfaces.IComputadora;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;
import edu.fiuba.algo3.modelo.pais.lugarActual.FueraDeEdificio;
import edu.fiuba.algo3.modelo.pais.lugarActual.Inactivo;
import edu.fiuba.algo3.modelo.pais.lugarActual.LugarActual;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.OrdenDeArresto;
import edu.fiuba.algo3.modelo.rangos.Novato;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;

public class Policia {

    LugarActual lugarActual;
    IRango rango;
    ITemporizador temporizador;
    IComputadora computadora;
    OrdenDeArresto ordenDeArresto;
    int heridasPorCuchillo;
    int cantidadArrestos;
    
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
        return rango.getClass().getSimpleName();
    }
    /*
    Ubicar al policia en el juego tras generar el robo
    */
    public void asignarCaso(IPais pais, EstadoDeJuego estado, ITemporizador temporizador, IComputadora computadora){
        this.computadora = computadora;
        lugarActual = new FueraDeEdificio(pais);
        ordenDeArresto = null;
        heridasPorCuchillo = 0;
        this.temporizador = temporizador;

        this.agregarSuscriptor(estado);
        temporizador.agregarSuscriptor(estado);
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

    public List<Ladron> consultarDatos(List<Propiedad> propiedades) {
        return computadora.consultarDatos(this, propiedades);
    }


}
