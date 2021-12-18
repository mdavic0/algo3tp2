package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControladorVentanaPais{
    Policia policia;
    Robo robo;
    private Temporizador t;
    private EstadoDeJuego estado;

    @FXML
    public Label nombreLugar;
    @FXML
    public Label diaYHora;
    @FXML
    public Label descripcionPais;
    @FXML
    public AnchorPane contenedorDerecha;

    public void inicializar(Policia policia, Robo robo, EstadoDeJuego estado, Temporizador t) {
        this.policia = policia;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        nombreLugar.setText(policia.paisActual().nombre());
        diaYHora.setText(t.fechaActual());
        //TODO descripcion de cada pais
        descripcionPais.setText(policia.paisActual().nombre());
    } 
    
    public void investigar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeJuego" + ".fxml"));
        try {
            contenedorDerecha.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
    }
}
