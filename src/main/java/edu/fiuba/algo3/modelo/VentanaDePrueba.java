package edu.fiuba.algo3.modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaDePrueba extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Nombre de la ventana");

        Label texto = new Label(" ");

        Button boton = new Button("Hola soy un boton");
        boton.setOnAction(e -> {texto.setText("Welcome to JavaFX Application!");});

        StackPane distribucion = new StackPane();
        distribucion.getChildren().addAll(boton, texto);

        Scene esceneario = new Scene(distribucion, 300, 200);

        stage.setScene(esceneario);
        stage.show();
    }

}
