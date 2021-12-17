package edu.fiuba.algo3;

import java.net.URL;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.Policia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControladorVentanaInicio  implements Initializable{

    @FXML
    public Label textoMaquinaDeEscribir;

    public void imprimirTextoPolicia (Policia policia){
        textoMaquinaDeEscribir.setText("Hola policia. Tu rango es" + policia.imprimirRango() + ".");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Policia policia = new Policia();
        imprimirTextoPolicia(policia);
        
    }

}
