package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ControladorVentanaComputadora  {

    @FXML
    public ChoiceBox<String> campoVehiculo;

    @FXML
    public ChoiceBox<String> campoSexo;

    @FXML
    public ChoiceBox<String> campoSenia;

    @FXML
    public ChoiceBox<String> campoHobby;

    @FXML
    public ChoiceBox<String> campoCabello;

    @FXML
    public SplitPane raiz;

    @FXML
    public Label textoInstructivo;

    private Policia policia;
    private FXMLLoader ventanaARegresar;
    
    public void inicializar(Policia policia, FXMLLoader ventanaARegresar) throws Exception {
        this.policia = policia;
        this.ventanaARegresar = ventanaARegresar;

        campoSexo.getItems().addAll("","M","F");
        campoSexo.setValue("");

        campoHobby.getItems().addAll("", "Tenis", "Música", "Alpinismo", "Paracaidismo", "Natación", "Croquet");
        campoHobby.setValue("");

        campoCabello.getItems().addAll("", "Castaño", "Rubio", "Rojo", "Negro");
        campoCabello.setValue("");

        campoSenia.getItems().addAll("", "Anillo", "Tatuaje", "Cicatriz", "Joyas");
        campoSenia.setValue("");

        campoVehiculo.getItems().addAll("", "Descapotable", "Limusina", "Deportivo", "Moto");
        campoVehiculo.setValue("");

    }

    public void consultarDatos(){

        String respuesta = "";

        List<Propiedad> propiedades = new ArrayList<>();

        String[] tipos = {"Vehiculo", "Genero", "Senia", "Hobby", "Cabello"};
        String[] inputs = {campoVehiculo.getValue(), campoSexo.getValue(), campoSenia.getValue(), campoHobby.getValue(), campoCabello.getValue()};

        for(int i = 0; i < tipos.length; i++) {
            if(!inputs[i].equals(""))
                propiedades.add(new Propiedad(tipos[i], inputs[i]));
        }

        List<Ladron> matches = policia.consultarDatos(propiedades);

        if(matches.size() > 1){
            for(Ladron match : matches){
                respuesta = respuesta.concat("Match: ").concat(match.nombre()).concat(".\n");
            }
            textoInstructivo.setText(respuesta);
        }
        else if(matches.size() == 1){
            textoInstructivo.setText("Emitiendo orden de arresto contra ".concat(matches.get(0).nombre()));
        }
        else {
            textoInstructivo.setText("No se encontró match :(");
        }
    }


    public void regresar(){
        Parent nodoARegresar = ventanaARegresar.getRoot();
        //TODO notificar regreso a la ventanaARegresar
        raiz.getScene().setRoot(nodoARegresar);
    }
}
