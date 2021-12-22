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
        comoJugar.setText("\tEl juego en sí es sumamente simple, como agente de la INTERPOL te dejarán en una \"escena del crimen\"" +
                " y deberás buscar el rastro de Carmen Sandiego desde la ciudad en la que ocurrió hasta encontrar donde se esconde." +
                " Para ello podrás usar la lupa para interrogar testigos de cada ciudad y reunir pistas." +
                " Cuando creas saber dónde está Carmen podrás usar el avión para viajar a la siguiente ciudad.\n\n" +
                "\tMientras vas jugando, Google Earth te dará información interesante sobre los sitios que visitas," +
                " de forma que aprendas algo mientras juegas.\n\n" +
                "\tEs bastante simple y entretenido, además de tener la ventaja de estar explorando sitios reales mientras" +
                " aprendes y te diviertes. En cuanto a juegos educativos se refiere, este viene excelente, no solo para " +
                "niños sino para adultos. ");
    }

    public void botonRegresar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeBienvenida" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }


}
