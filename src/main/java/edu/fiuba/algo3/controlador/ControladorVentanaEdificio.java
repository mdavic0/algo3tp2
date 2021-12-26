package edu.fiuba.algo3.controlador;

import java.io.IOException;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.robo.Robo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorVentanaEdificio{
    Policia policia;
    Robo robo;
    private Edificio edificio;
    private Temporizador t;
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

    private FXMLLoader ventanaARegresar;
    private FXMLLoader ventanaEdificio;


    public void inicializar(Policia policia, Edificio edificio, Robo robo, EstadoDeJuego estado, Temporizador t, FXMLLoader ventanaARegresar, FXMLLoader ventanaEdificio) throws Exception {
        this.policia = policia;
        this.edificio = edificio;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        this.ventanaEdificio = ventanaEdificio;
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


    public void anotar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeNotas" + ".fxml"));

        try {
            Parent padre = fxmlLoader.load();
            raiz.getScene().setRoot(padre);
            ((ControladorVentanaNotas)fxmlLoader.getController()).inicializar(policia, t, ventanaEdificio);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

}
