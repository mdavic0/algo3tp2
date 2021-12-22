package edu.fiuba.algo3.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentanaCreditos implements Initializable {
    @FXML
    public AnchorPane raiz;

    @FXML
    public Label tpAlgoThief;

    @FXML
    public Label versionJava;

    @FXML
    public Label versionJavaFX;

    @FXML
    public Label desarrolladores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tpAlgoThief.setText("TP2 Algoritmos 3: Algo-thief");
        versionJava.setText("Version de Java:\n\t- " + System.getProperty("java.version"));
        versionJavaFX.setText("Version de JavaFX:\n\t- " + System.getProperty("javafx.version"));
        desarrolladores.setText("Desarrolladores:\n- Mauricio Davico\n" + "- María Fernanda Pont Tovar\n" + "- Franco Pomi");

    }

    public void botonRegresar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeBienvenida" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

}
