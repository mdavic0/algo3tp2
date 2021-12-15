package edu.fiuba.algo3.modelo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaDePrueba extends Application {

   public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start (Stage ventana) throws Exception{
        Parent root = FXMLLoader.load("VentanaDeConfirmacion.fxml");
        ventana.setTitle("A");
        ventana.setScene(new Scene (root, 600, 500));
        ventana.show();
    }

}


