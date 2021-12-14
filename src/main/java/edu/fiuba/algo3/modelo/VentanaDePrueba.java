package edu.fiuba.algo3.modelo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaDePrueba extends Application {

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void star (Stage ventana) throws Exception{
        Parent raiz = FXMLLoader.load(getClass().getResource("VentanaDeInicio.fxml"));
        ventana.setTitle("");
        ventana.setScene(new Scene (raiz, 300, 400));
        ventana.Show();
    }

}
