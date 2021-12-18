package edu.fiuba.algo3;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentadaBienvenida implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void botonJugar(){
        System.out.println("Jugar");
    }

    public void botonPuntajes(){
        System.out.println("Puntajes");
    }

    public void botonAyuda(){
        System.out.println("Ayuda");
    }

    public void botonCreditos(){
        System.out.println("Creditos");
    }

    public void botonSalir(){
        Platform.exit();
    }


}

