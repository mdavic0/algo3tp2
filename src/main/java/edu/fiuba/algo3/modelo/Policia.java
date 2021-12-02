package edu.fiuba.algo3.modelo;

public class Policia {

    LugarActual lugarActual;
    String pista; //idealmente una coleccion
    Rango rango;

    public Policia(IPais colombia) {
        lugarActual = new FueraDeEdificio(colombia);
        rango = new Novato();
    }

    public void entrarA(IEdificio banco) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(banco);
    }

    public String cuestionarTestigo() throws Exception {
        return this.lugarActual.cuestionarTestigo();
    }

    public void viajarA(IPais mexico) throws Exception {
        lugarActual = this.lugarActual.viajarA(mexico);
    }

    public IPais paisActual() {
        return this.lugarActual.obtenerPais();
    }
}
