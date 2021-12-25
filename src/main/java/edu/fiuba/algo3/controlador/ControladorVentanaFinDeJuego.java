package edu.fiuba.algo3.controlador;

import java.io.IOException;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.robo.Robo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ControladorVentanaFinDeJuego {
    @FXML
    public Label texto;
    @FXML
    public AnchorPane raiz;

    Policia policia;
    
    public void inicializar(Policia policia, EstadoDeJuego estado, Robo robo){
        this.policia = policia;
        texto.setText(estado.reportarAlUsuario(robo.obtenerLadron()));
    }

    public void botonRegresar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeBienvenida" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
        ((ControladorVentadaBienvenida)fxmlLoader.getController()).inicializar(policia);
    }

}
