package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorVentanaInicio  implements Initializable{
    private String ultimoInput;
    Policia policia;
    Robo robo;
    LectorDeArchivo lector;

    @FXML
    public Label textoMaquinaDeEscribir;
    @FXML
    public TextField inputJugador;
    @FXML
    public SplitPane raiz;
    
    public void handleOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){
            try {
                if(robo == null)
                    recibeInputJugador();
                else abrirVentanaJuego(event, robo, policia);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    } 

    private void abrirVentanaJuego(KeyEvent event, Robo robo, Policia policia) throws IOException {
        EstadoDeJuego estado = new EstadoDeJuego();
        Temporizador t = new Temporizador(7, 20);
        try {
            policia.asignarCaso(robo.lugarDeRobo(), estado, t, new Computadora(lector.obtenerLadrones()));
        } catch (Exception e) {
            throw new IOException("Fracaso leyendo el JSON de ladrones");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeJuego" + ".fxml"));
        Scene escenaActual = inputJugador.getScene();
        escenaActual.setRoot(fxmlLoader.load());
        ((ControladorVentanaPais)fxmlLoader.getController()).inicializar(policia, policia.paisActual(), robo, estado, t, fxmlLoader);
    }

    public void imprimirTextoPolicia (Policia policia){
        textoMaquinaDeEscribir.setText("Hola policia. Tu rango es" + policia.imprimirRango() + ". Ingresá tu nombre!");
    }

    public void recibeInputJugador() throws Exception{
        ultimoInput = inputJugador.getText();
        generarRobo();
        inputJugador.setText("");
        textoMaquinaDeEscribir.setText(huboUnRobo());
    } 
    private String huboUnRobo() {
        String texto = "Hola," + ultimoInput + ". Hubo un robo en" + robo.lugarDeRobo().nombre() + ".";
        return texto;
    }

    private void generarRobo() throws Exception{
        ultimoInput = inputJugador.getText();
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<IPais> paises =  lector.obtenerPaises();
        robo = gRobo.generarRobo(policia, lector.obtenerArtefactos(), paises, lector.obtenerLadrones());

        //TODO no usar getter de policia
        GeneradorDeEdificios genEdificios = new GeneradorDeEdificios(robo, policia.obtenerRango());
        genEdificios.crearEdificiosPara(paises, robo);
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        policia = new Policia();
        lector = new LectorDeArchivo();
        imprimirTextoPolicia(policia);
        
    }

    //opcional si hay policia de una partida anterior
    public void inicializar(Policia policia){
        this.policia = policia;
        imprimirTextoPolicia(policia);
    }
}
