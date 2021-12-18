package edu.fiuba.algo3;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentanaCreditos implements Initializable {
    @FXML
    public Label versionJava;

    @FXML
    public Label versionJavaFX;

    @FXML
    public Label desarrolladores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        versionJava.setText("Version de Java:\n" + System.getProperty("java.version"));
        versionJavaFX.setText("Version de JavaFX:\n" + System.getProperty("javafx.version"));
        desarrolladores.setText("Desarrolladores:\n\n- Mauricio Davico\n" +
                "- María Fernanda Pont Tovar\n" +
                "- Franco Pomi");
    }

    public void botonRegresar(){
        System.out.print("Regresar");
    }

}
