package edu.fiuba.algo3;

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
    public void start (Stage ventana) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaDePrueba.class.getResource("VentanaDeConfirmacion" + ".fxml"));
        ventana.setTitle("");
        ventana.setScene(new Scene (fxmlLoader.load()));
        ventana.show();
    }

}


