package edu.fiuba.algo3;

import java.net.URL;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.Policia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorVentanaInicio  implements Initializable{
    private String ultimoInput;

    @FXML
    public Label textoMaquinaDeEscribir;
    @FXML
    public TextField inputJugador;
    
    public void handleOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){
            recibeInputJugador();
        }
    } 

    public void imprimirTextoPolicia (Policia policia){
        textoMaquinaDeEscribir.setText("Hola policia. Tu rango es" + policia.imprimirRango() + ". Ingresá tu nombre!");
    }

    public void recibeInputJugador(){
        ultimoInput = inputJugador.getText();
        textoMaquinaDeEscribir.setText("Hola, "+ ultimoInput);
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Policia policia = new Policia();
        imprimirTextoPolicia(policia);
        
    }

}
