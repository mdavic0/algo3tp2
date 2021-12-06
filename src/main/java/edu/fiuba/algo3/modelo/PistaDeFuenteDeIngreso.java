package edu.fiuba.algo3.modelo;

public class PistaDeFuenteDeIngreso extends Pista {

    public PistaDeFuenteDeIngreso(String nombreIngresoEconomico) {
        this.contenido = "Su fuente de ingreso es/son ".concat(nombreIngresoEconomico).concat(".");
    }

    @Override
    public Object dificultad() {
        return new Dificil();
    }

}
