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
    IRobo robo;
    private ITemporizador t;
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
    private IEdificio edificio;
    
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

    public void inicializar(Policia policia, IEdificio edificio, IRobo robo, EstadoDeJuego estado, ITemporizador t) throws Exception {
        this.policia = policia;
        this.edificio = edificio;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
    } 
    
    public void regresar(){
        try {

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeJuego" + ".fxml"));
        for(Node node : raiz.getItems()){
            node.setVisible(false);
        }
            raiz.getItems().add(fxmlLoader.load());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
        //regresar
        
    }
    
    public void anotar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDePistas" + ".fxml"));
        try {
            notas = fxmlLoader.load();
            contenedorDerecha.getItems().add(notas);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void notificarEntrada() {
        try {
            nombreLugar.setText(edificio.nombre());
            diaYHora.setText(t.fechaActual());
            policia.entrarA(edificio);
            pista.setText(policia.cuestionarTestigo());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
