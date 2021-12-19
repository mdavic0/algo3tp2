package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControladorVentanaEdificio{
    Policia policia;
    Robo robo;
    private Temporizador t;
    private EstadoDeJuego estado;

    @FXML
    public Label nombreLugar;
    @FXML
    public Label diaYHora;
    @FXML
    public Label pista;
    @FXML
    public SplitPane contenedorDerecha;
    @FXML
    public SplitPane raiz;

    Parent notas;
    private Edificio edificio;
    
    public void handleOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE){
            try {
                contenedorDerecha.getItems().remove(notas);
                for(Node node : raiz.getItems()){
                    node.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    } 

    public void inicializar(Policia policia, Edificio edificio, Robo robo, EstadoDeJuego estado, Temporizador t) throws Exception {
        this.policia = policia;
        this.edificio = edificio;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        nombreLugar.setText(edificio.nombre());
        diaYHora.setText(t.fechaActual());
        //TODO descripcion de cada pais
        pista.setText(policia.cuestionarTestigo());
    } 
    
    public void regresar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeJuego" + ".fxml"));
        for(Node node : raiz.getItems()){
            node.setVisible(false);
        }
        try {
            raiz.getItems().add(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
        ((ControladorVentanaPais)fxmlLoader.getController()).inicializar(policia, robo, estado, t);
        
    }
    
    public void anotar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDePistas" + ".fxml"));
        try {
            notas = fxmlLoader.load();
            contenedorDerecha.getItems().add(notas);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
    }
}
