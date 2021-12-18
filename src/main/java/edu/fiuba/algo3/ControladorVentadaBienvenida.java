package edu.fiuba.algo3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentadaBienvenida implements Initializable {
    @FXML
    public AnchorPane raiz;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void botonJugar() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeInicio" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
        //((ControladorVentanaInicio)fxmlLoader.getController()).inicializar(???);
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

