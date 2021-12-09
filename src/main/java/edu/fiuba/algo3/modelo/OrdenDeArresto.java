package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class OrdenDeArresto {

    Ladron sospechoso;

    public OrdenDeArresto (Ladron unLadron){
        this.sospechoso = unLadron;
    }

    public boolean puedeArrestarA (Ladron elLadron){
        return Objects.equals(this.sospechoso.nombre(), elLadron.nombre()); //sacar el .nombre() cuando tengamos los JSON's
    }

    public Ladron sospechoso(){
        return sospechoso;
    }

}
