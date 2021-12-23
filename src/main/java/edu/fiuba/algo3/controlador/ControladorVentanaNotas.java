package edu.fiuba.algo3.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class ControladorVentanaNotas {

    @FXML
    Label nombreLugar;

    @FXML
    Label diaYHora;

    @FXML
    Button botonRegresar;

    @FXML
    SplitPane raiz;

    private FXMLLoader ventanaARegresar;

    public void inicializar (FXMLLoader ventanaARegresar){
        this.ventanaARegresar = ventanaARegresar;
    }

    public void botonDeRegreso () throws IOException {
        ((ControladorVentanaPais)ventanaARegresar.getController()).actualizarInterfaz();
        raiz.getScene().setRoot(ventanaARegresar.getRoot());
    }

}
