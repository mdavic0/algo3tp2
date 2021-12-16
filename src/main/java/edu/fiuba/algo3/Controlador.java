package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Temporizador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controlador {

    @FXML
    public Label labelResultado;

    Temporizador t = new Temporizador(0);

    public void botonSi (){
        System.out.println(t.horaActual());
        labelResultado.setText(String.valueOf(t.horaActual()));

    }

    public void botonNo (){
        t.reportarActividad(4);
    }

}
