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
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pais.lugarActual.FueraDeEdificio;
import edu.fiuba.algo3.modelo.pais.lugarActual.Inactivo;
import edu.fiuba.algo3.modelo.pais.lugarActual.LugarActual;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Computadora;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.OrdenDeArresto;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.policia.rangos.Novato;
import edu.fiuba.algo3.modelo.policia.rangos.Rango;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.Propiedad;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;

public class Policia {

    LugarActual lugarActual;
    Rango rango;
    Temporizador temporizador;
    Computadora computadora;
    OrdenDeArresto ordenDeArresto;

    int heridasPorCuchillo;
    int cantidadArrestos;
    private final String nombre;
    
    List<PropertyChangeListener> suscriptores = new ArrayList<PropertyChangeListener>();

    public Policia(String nombre) {
        lugarActual = new Inactivo();
        rango = new Novato();
        ordenDeArresto = null;
        cantidadArrestos = 0;
        this.nombre = nombre;
    }


    public Policia() {
        lugarActual = new Inactivo();
        rango = new Novato();
        ordenDeArresto = null;
        cantidadArrestos = 0;
        this.nombre = "Jugador";
    }


    public String nombre(){
        return nombre;
    }

    public Rango obtenerRango(){
        return rango;
    }

    public String imprimirRango() {
        return rango.getClass().getSimpleName();
    }

    /*
    Ubicar al policia en el juego tras generar el robo
    */
    public void asignarCaso(Pais pais, EstadoDeJuego estado, Temporizador temporizador, Computadora computadora){
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

    public void entrarA(Edificio edificio) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(edificio, this);
    }

    public String cuestionarTestigo() throws Exception {
        return this.lugarActual.cuestionarTestigo();
    }

    public void viajarA(Pais paisDestino) throws Exception {
        lugarActual = this.lugarActual.viajarA(paisDestino);
        this.rango.reportarViaje(this.paisActual(), paisDestino, this.temporizador);
    }

    public Pais paisActual() {
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
        if(this.puedeArrestar(ladron)){
            arrestarLadron();
            notificarSuscriptores(
                new PropertyChangeEvent(this, "Arresto", cantidadArrestos, cantidadArrestos + 1));
        }
            
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


    public Artefacto generarArtefacto(List<Artefacto> artefactos) {
        return this.rango.generarArtefacto(artefactos);
    }

}
