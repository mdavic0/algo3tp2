package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Temporizador;

public class Controlador {

    Temporizador t = new Temporizador(0,0,0);

    public void botonSi (){
        System.out.println(t.horaActual());
    }

    public void botonNo (){
        t.reportarActividad(4);
    }

}
