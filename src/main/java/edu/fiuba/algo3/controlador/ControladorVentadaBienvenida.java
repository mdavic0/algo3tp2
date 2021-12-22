package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControladorVentadaBienvenida {
    @FXML
    public AnchorPane raiz;

    public void botonJugar() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeInicio" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
        //((ControladorVentanaInicio)fxmlLoader.getController()).inicializar(???);
    }

    public void botonPuntajes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDePuntajes" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

    public void botonAyuda() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeAyuda" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

    public void botonCreditos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeCreditos" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

    public void botonSalir(){
        Platform.exit();
    }


}

