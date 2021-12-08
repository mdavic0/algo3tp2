package edu.fiuba.algo3.modelo;

public class OrdenDeArresto {

    Ladron sospechoso;

    public OrdenDeArresto (Ladron unLadron){
        this.sospechoso = unLadron;
    }

    public boolean puedeArrestarA (Ladron elLadron){
        return (this.sospechoso.nombre() == elLadron.nombre())? true: false; //sacar el .nombre() cuando tengamos los JSON's
    }

}
