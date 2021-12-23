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

public class ControladorVentanaAyuda implements Initializable {
    @FXML
    public AnchorPane raiz;

    @FXML
    public Label comoJugar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comoJugar.setText("Carmen Sandiego es el nombre de la jefa de una peligrosa organización mundial dedicada" +
                " al robo a gran escala. Cualquier valioso tesoro, por inaccesible que sea el lugar del planeta donde" +
                " se encuentre , corre el riesgo de situarse en el punto de mira de la organización y cambiar de residencia" +
                " en un abrir y cerrar de ojos.\n\n" +
                "La interpol anda desde hace algunos años sobre la pista de Carmen y su banda pero hasta ahora han sido incapaces" +
                " de encontrar las pruebas suficientes para ponerles de una vez por todas entre rejas.\n\n" +
                "En este juego seremos el detective encargado del caso. Tu misión es recorrer el mundo tras las huellas de los " +
                "miembros de la banda.\n\n" +
                "Tendremos carta blanca en lo que respecta a los fondos de la Interpol. Podrás viajar a los lugares más remotos " +
                "del globo siempre y cuando consigas capturar al ladrón y recuperar lo robado, en un periodo de tiempo limitado" +
                " que han establecido previamente sus superiores.\n" +
                "\n" +
                "Nos harán falta unos conocimientos muy profundos sobre cientos de países."

        );
    }

    public void botonRegresar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeBienvenida" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }


}
