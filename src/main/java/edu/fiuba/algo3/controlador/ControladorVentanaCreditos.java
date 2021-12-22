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
    public Label desarrolladores;

    @FXML
    public Label descripcion;

    @FXML
    public Label versionJava;

    @FXML
    public Label versionJavaFX;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tpAlgoThief.setText("TP2 Algoritmos 3: \n- \"Algo-thief\"");
        desarrolladores.setText("Desarrolladores:\n- Mauricio Davico\n" + "- María Fernanda Pont Tovar\n" + "- Franco Pomi");
        descripcion.setText("Genero: - Educativo\n\n" +
                            "Año: - 2021\n\n" +
                            "Controles: - Teclado/Ratón\n\n" +
                            "Idioma: - Español\n\n"
        );
        versionJava.setText("Version de Java: - " + System.getProperty("java.version"));
        versionJavaFX.setText("Version de JavaFX: - " + System.getProperty("javafx.version"));


    }

    public void botonRegresar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeBienvenida" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

}
