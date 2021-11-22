package edu.fiuba.algo3.modelo;

public class Policia {

    LugarActual lugarActual;
    String pista; //idealmente una coleccion

    public Policia(Pais pais) {
        lugarActual = new FueraDeEdificio(pais);
    }

    public void entrarA(Edificio unEdificio) throws Exception{
        this.lugarActual = this.lugarActual.entrarA(unEdificio);
        this.cuestionarTestigo(this.lugarActual.obtenerTestigo());
    }

    public String cuestionarTestigo() throws Exception {
        return cuestionarTestigo(this.lugarActual.obtenerTestigo());
    }

    private String cuestionarTestigo(Testigo testigo) {
        pista = testigo.cuestionar();
        return pista;
    }

}
