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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ControladorVentanaComputadora  {
    @FXML
    public TextField campoVehiculo;
    @FXML
    public TextField campoSexo;
    @FXML
    public TextField campoSenia;
    @FXML
    public TextField campoHobby;
    @FXML
    public TextField campoCabello;
    @FXML
    public SplitPane raiz;
    @FXML
    public Label textoInstructivo;

    private Policia policia;
    private Computadora computadora;
    private FXMLLoader ventanaARegresar;
    
    public void inicializar(Policia policia, FXMLLoader ventanaARegresar) throws Exception {
        this.policia = policia;
        this.ventanaARegresar = ventanaARegresar;
        this.computadora = new Computadora();
    }

    public void consultarDatos(){
        List<Propiedad> propiedades = new ArrayList<>();
        TextField[] inputs = {campoVehiculo, campoSexo, campoSenia, campoHobby, campoCabello};
        String[] tipos = {"Vehiculo", "Genero", "Senia", "Hobby", "Cabello"};
        for(int i = 0; i < tipos.length; i++) {
            if(!inputs[i].getText().equals(""))
                propiedades.add(new Propiedad(tipos[i], inputs[i].getText()));
        }
        List<Ladron> matches = policia.consultarDatos(propiedades);

        String respuesta = new String();
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
