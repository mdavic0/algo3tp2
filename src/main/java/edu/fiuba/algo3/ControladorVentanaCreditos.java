package edu.fiuba.algo3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentanaCreditos implements Initializable {
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
        desarrolladores.setText("Desarrolladores:\n\n- Mauricio Davico\n" +
                "- María Fernanda Pont Tovar\n" +
                "- Franco Pomi");

    }

    public void botonRegresar(){
        System.out.print("Regresar");
    }

}
