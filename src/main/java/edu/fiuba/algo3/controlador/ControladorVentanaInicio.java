package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Computadora;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.robo.GeneradorDeRobo;
import edu.fiuba.algo3.modelo.robo.Robo;
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
                if(policia == null)
                    crearNuevoPolicia();
                if (robo == null){
                    reportarRobo();
                }
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
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeJuego.fxml"));
        Scene escenaActual = inputJugador.getScene();
        escenaActual.setRoot(fxmlLoader.load());
        ((ControladorVentanaPais)fxmlLoader.getController()).inicializar(policia, policia.paisActual(), robo, estado, t, fxmlLoader);
    }

    public void imprimirTextoParaPoliciaNuevo (Policia policia){
        textoMaquinaDeEscribir.setText("Hola policia. Tu rango es Novato. Ingresá tu nombre...");
    }

    private void imprimirTextoPoliciaPreexistente(Policia policia) {
        textoMaquinaDeEscribir.setText("Hola de nuevo, " + policia.nombre() + ". Tu rango es " 
            + policia.imprimirRango() + ". Presione ENTER.");
    }

    public void crearNuevoPolicia() throws Exception{
        ultimoInput = inputJugador.getText();
        if(ultimoInput != "") policia = new Policia(ultimoInput);
        else policia = new Policia();
    } 

    private void reportarRobo() throws Exception{
        generarRobo();
        inputJugador.setText("");
        textoMaquinaDeEscribir.setText(huboUnRobo(policia.nombre()));
    }
    private String huboUnRobo(String nombre) {
        String texto = "Hola, "+nombre+". Hubo un robo en " + robo.lugarDeRobo().nombre() + ".";
        return texto;
    }

    private void generarRobo() throws Exception{
        ultimoInput = inputJugador.getText();
        GeneradorDeRobo gRobo = new GeneradorDeRobo();
        List<Pais> paises =  lector.obtenerPaises();
        robo = gRobo.generarRobo(policia, lector.obtenerArtefactos(), paises, lector.obtenerLadrones());
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lector = new LectorDeArchivo();
        imprimirTextoParaPoliciaNuevo(policia);
        
    }

    //opcional si hay policia de una partida anterior
    public void inicializar(Policia policia){
        this.policia = policia;
        imprimirTextoPoliciaPreexistente(policia);
    }
}
