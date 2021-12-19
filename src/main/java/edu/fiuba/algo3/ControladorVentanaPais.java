package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

public class ControladorVentanaPais {
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
    public SplitPane contenedorDerecha;
    @FXML
    public SplitPane raiz;

    Parent notas;
    private FXMLLoader selfLoader;
    
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

    public void inicializar(Policia policia, Robo robo, EstadoDeJuego estado, Temporizador t, FXMLLoader self) {
        this.policia = policia;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        this.selfLoader = self;
        nombreLugar.setText(policia.paisActual().nombre());
        diaYHora.setText(t.fechaActual());
        //TODO descripcion de cada pais
        descripcionPais.setText(policia.paisActual().nombre());
    } 
    
    public void investigar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeOpciones" + ".fxml"));
        try {
            raiz.getScene().setRoot(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }

        List<FXMLLoader> vistasEdificios = new ArrayList<FXMLLoader>();
        FXMLLoader ventanaEdificio = new FXMLLoader(this.getClass().getResource("VentanaDeEdificio.fxml"));
        try {
            ventanaEdificio.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            ((ControladorVentanaEdificio) ventanaEdificio.getController())
                .inicializar(policia, policia.paisActual().edificios().get(0), robo, estado, t, selfLoader);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        vistasEdificios.add(ventanaEdificio);
        ((ControladorVentanaOpcionesEdificios)fxmlLoader.getController())
            .inicializar(policia, policia.paisActual(), fxmlLoader, selfLoader, vistasEdificios);
        
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
