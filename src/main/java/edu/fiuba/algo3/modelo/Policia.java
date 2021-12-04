package edu.fiuba.algo3.modelo;

public class Policia {

    LugarActual lugarActual;
    //String pista; //idealmente una coleccion
    Rango rango;
    Temporizador temporizador;
    int cantidadArrestos;
    int heridasPorCuchillo;

    public Policia(IPais pais, Temporizador temporizador) {
        lugarActual = new FueraDeEdificio(pais);
        rango = new Novato();
        this.temporizador = temporizador;
        cantidadArrestos = 0;
        heridasPorCuchillo = 0;
    }

<<<<<<< HEAD
    public Policia(IPais colombia, Temporizador t) {
        lugarActual = new FueraDeEdificio(colombia);
        rango = new Novato();
        this.t = t;
    }

    public void salirDelEdificio() throws Exception{
        this.lugarActual = this.lugarActual.salirDelEdificio();
    }

    public void entrarA(IEdificio banco) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(banco);
=======
    public void entrarA(IEdificio edificio) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(edificio);
>>>>>>> experimental
    }

    public String cuestionarTestigo() throws Exception {
        return this.lugarActual.cuestionarTestigo();
    }

    public void viajarA(IPais paisDestino) throws Exception {
        lugarActual = this.lugarActual.viajarA(paisDestino);
        this.temporizador.reportarActividad(new Viajar(this.paisActual(), paisDestino, this.rango.velocidadKmh()));
    }

    public IPais paisActual() {
        return this.lugarActual.obtenerPais();
    }

    public void salirDe(Edificio edificio) throws Exception {
        this.lugarActual = this.lugarActual.salirDe(edificio);
    }

    public void recibirHeridaConCuchillo() throws Exception {
        this.temporizador.reportarActividad(new HeridaConCuchillo(heridasPorCuchillo++));
    }

    public void recibirHeridaConArmaDeFuego() throws Exception {
        this.temporizador.reportarActividad(new HeridaConArmaDeFuego());
    }

    public void arrestarLadron(){
        cantidadArrestos++;
        if(cantidadArrestos %5 == 0){
            this.rango = rango.subirRango();
        }
    }

    public void emitirOrdenDeArresto() throws Exception {
        this.temporizador.reportarActividad(new EmitirOrdenDeArresto());
    }

}
