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
    private IPais pais;
    
    public void handleOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE){
            try {
                contenedorDerecha.getItems().remove(notas);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    } 

    public void inicializar(Policia policia, IPais pais, Robo robo, EstadoDeJuego estado, Temporizador t, FXMLLoader self) {
        this.policia = policia;
        this.pais = pais;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        this.selfLoader = self;
        nombreLugar.setText(pais.nombre());
        diaYHora.setText(t.fechaActual());
        //TODO descripcion de cada pais
        descripcionPais.setText(pais.nombre());
    } 
    
    public void investigar() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeOpciones" + ".fxml"));
        
        raiz.getScene().setRoot(fxmlLoader.load());
        List<FXMLLoader> vistasEdificios = new ArrayList<FXMLLoader>();
        for(int i = 0; i < policia.paisActual().edificios().size();i++){
            FXMLLoader ventanaEdificio = new FXMLLoader(this.getClass().getResource("VentanaDeEdificio.fxml"));
            ventanaEdificio.load();
            ((ControladorVentanaEdificio) ventanaEdificio.getController())
                .inicializar(policia, policia.paisActual().edificios().get(i), robo, estado, t, selfLoader);
            vistasEdificios.add(ventanaEdificio);
        }
        
    
        ((ControladorVentanaOpcionesEdificios)fxmlLoader.getController())
            .inicializar(policia, policia.paisActual(), vistasEdificios);
    }

    public void viajar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeOpcionesViaje" + ".fxml"));
        try {
            raiz.getScene().setRoot(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }

        List<FXMLLoader> vistasPaises = new ArrayList<FXMLLoader>();
        for(int i = 0; i < 3; i++){
            FXMLLoader ventanaPais = new FXMLLoader(this.getClass().getResource("VentanaDeJuego.fxml"));
            try {
                ventanaPais.load();
                ((ControladorVentanaPais) ventanaPais.getController())
                    .inicializar(policia, policia.paisActual().obtenerAdyacentes().get(i), robo, estado, t, ventanaPais);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            vistasPaises.add(ventanaPais);
        } 
        ((ControladorVentanaOpcionesPais)fxmlLoader.getController())
            .inicializar(policia, policia.paisActual(), vistasPaises);
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

    public void notificarLlegada() throws Exception {
        policia.viajarA(pais);
    }

    public void actualizarInterfaz() {
        inicializar(policia, pais, robo, estado, t, selfLoader);
    }
}
