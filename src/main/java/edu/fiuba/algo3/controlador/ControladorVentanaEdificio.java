package edu.fiuba.algo3.controlador;

import java.io.IOException;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IRobo;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;
import edu.fiuba.algo3.modelo.policia.Policia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    private FXMLLoader ventanaARegresar;
    
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

    public void inicializar(Policia policia, IEdificio edificio, IRobo robo, EstadoDeJuego estado, ITemporizador t, FXMLLoader ventanaARegresar) throws Exception {
        this.policia = policia;
        this.edificio = edificio;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        this.ventanaARegresar = ventanaARegresar;
    } 
    
    public void regresar(){
        //TODO: bug porque recobra pagina pais sin actualizar hora
        try {
            policia.salirDelEdificio();
            ((ControladorVentanaPais)ventanaARegresar.getController()).actualizarInterfaz();
            raiz.getScene().setRoot(ventanaARegresar.getRoot());
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
            if(!estado.juegoEnProgreso()) intentarAtraparLadron();
            else pista.setText(policia.cuestionarTestigo());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void intentarAtraparLadron() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VentanaFinDeJuego.fxml"));
        Parent nuevaRaiz = fxmlLoader.load();
        raiz.getItems().clear();
        raiz.getItems().add(nuevaRaiz);
        ((ControladorVentanaFinDeJuego)fxmlLoader.getController()).inicializar(policia, estado, robo);
    }
}
