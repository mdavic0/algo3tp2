package edu.fiuba.algo3;

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

public class ControladorVentanaPais{
    Policia policia;
    Robo robo;

    @FXML
    public Label nombreLugar;

    public void inicializar(Policia policia, Robo robo) {
        this.policia = policia;
        this.robo = robo;
        nombreLugar.setText(policia.paisActual().nombre());
    } 
    
    public void funcion(){

    }
}
