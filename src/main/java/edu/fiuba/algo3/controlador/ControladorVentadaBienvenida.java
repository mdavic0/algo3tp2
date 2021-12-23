package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Policia;

public class ControladorVentadaBienvenida {
    @FXML
    public AnchorPane raiz;

    private Policia policia;

    public void botonJugar() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeInicio" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
        ControladorVentanaInicio controlador = ((ControladorVentanaInicio)fxmlLoader.getController());
        if(policia != null) controlador.inicializar(policia);
    }

    public void botonPuntajes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDePuntajes" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

    public void botonAyuda() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeAyuda" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

    public void botonCreditos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeCreditos" + ".fxml"));
        Scene escenaActual = raiz.getScene();
        escenaActual.setRoot(fxmlLoader.load());
    }

    public void botonSalir(){
        Platform.exit();
    }

    // inicialziacion con policia es opcional, por default asume policia novato.
    public void inicializar(Policia policia) {
        this.policia = policia;
    }


}

