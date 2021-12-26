package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControladorVentanaNotas {

    @FXML
    public Label nombreLugar;

    @FXML
    public Label diaYHora;

    @FXML
    public TextFlow contenedorDeNotas;
    private TextFlow notas;
    @FXML
    public TextArea cosasParaAnotar;

    @FXML
    public SplitPane raiz;

    private FXMLLoader ventanaARegresar;

    public void inicializar (Policia paco, Temporizador t, FXMLLoader ventanaARegresar, TextFlow notas){

        this.ventanaARegresar = ventanaARegresar;
        this.nombreLugar.setText(paco.paisActual().nombre());
        this.diaYHora.setText(t.fechaActual());
        this.notas = notas;
        this.contenedorDeNotas.getChildren().addAll(notas.getChildren());
    }

    public void anotar (){
        Text t1 = new Text(cosasParaAnotar.getText() + "\n");
        contenedorDeNotas.getChildren().add(t1);
        cosasParaAnotar.clear();
    }

    public void botonDeRegreso () {
        notas.getChildren().addAll(contenedorDeNotas.getChildren());
        raiz.getScene().setRoot(ventanaARegresar.getRoot());
    }

}