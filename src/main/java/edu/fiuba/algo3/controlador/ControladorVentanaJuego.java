package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ControladorVentanaJuego  implements Initializable{
    private String ultimoInput;
    Policia policia;
    Robo robo;

    @FXML
    public Label textoMaquinaDeEscribir;
    @FXML
    public TextField inputJugador;
    @FXML
    public SplitPane raiz;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        policia = new Policia();
        
    }

}
