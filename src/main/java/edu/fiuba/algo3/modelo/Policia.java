package edu.fiuba.algo3.modelo;

public class Policia {

    LugarActual lugarActual;
    String pista; //idealmente una coleccion
    Rango rango;
    Temporizador t = new Temporizador(9, 20, 36);
    int cantidadArrestos;

    public Policia(IPais colombia) {
        lugarActual = new FueraDeEdificio(colombia);
        rango = new Novato();
        cantidadArrestos = 0;
    }

    public Policia(IPais colombia, Temporizador t) {
        lugarActual = new FueraDeEdificio(colombia);
        rango = new Novato();
        this.t = t;
    }

    public void entrarA(IEdificio banco) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(banco);
    }

    public String cuestionarTestigo() throws Exception {
        return this.lugarActual.cuestionarTestigo();
    }

    public void viajarA(IPais pais) throws Exception {
        lugarActual = this.lugarActual.viajarA(pais);
    }

    public IPais paisActual() {
        return this.lugarActual.obtenerPais();
    }

    public void salirDe(Edificio banco) throws Exception {
        this.lugarActual = this.lugarActual.salirDe(banco);
    }

    public void recibirHeridaConCuchillo() throws Exception {
        int duracionCuchillo = 3;
        this.t.reportarActividad(new Actividad(duracionCuchillo));
    }

    public void arrestarLadron(){
        cantidadArrestos++;
        if(cantidadArrestos %5 == 0){
            this.rango = rango.subirRango();
        }
    }

}
