package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.robo.Robo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyEvent;

public class ControladorVentanaPais {
    Policia policia;
    Robo robo;
    private Temporizador t;
    private EstadoDeJuego estado;

    @FXML
    public Label nombreLugar;
    @FXML
    public Label diaYHora;
    @FXML
    public Label descripcionPais;
    @FXML
    public SplitPane contenedorDerecha;
    @FXML
    public SplitPane raiz;

    Parent notas;
    private FXMLLoader selfLoader;
    private IPais pais;

    List<Node> itemsQuitadosAlAnotar;
    
    public void handleOnKeyPressed(KeyEvent event) {
        /* if (event.getCode() == KeyCode.ESCAPE){
            try {
                contenedorDerecha.getItems().remove(notas);
                for(Node n : itemsQuitadosAlAnotar){
                    contenedorDerecha.getItems().add(n);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        } */
    } 

    public void inicializar(Policia policia, IPais pais, Robo robo, EstadoDeJuego estado, Temporizador t, FXMLLoader self) throws IOException {
        this.policia = policia;
        this.pais = pais;
        this.robo = robo;
        this.estado = estado;
        this.t = t;
        this.selfLoader = self;
        nombreLugar.setText(pais.nombre());
        diaYHora.setText(t.fechaActual());
        //TODO descripcion de cada pais
        descripcionPais.setText(pais.descripcion());

        if (estado.juegoPerdido()){
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeFinDeJuego" + ".fxml"));
            raiz.getScene().setRoot(fxmlLoader.load());
        }
    } 

    public void verPosiblesDestinos() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDePosiblesDestinos" + ".fxml"));

        try {
            Parent padre = fxmlLoader.load();
            raiz.getScene().setRoot(padre);
            ((ControladorVentanaPosiblesDestinos)fxmlLoader.getController()).inicializar(selfLoader, policia);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void investigar() throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeOpcionesEdificios" + ".fxml"));
        
        raiz.getScene().setRoot(fxmlLoader.load());
        List<FXMLLoader> vistasEdificios = new ArrayList<FXMLLoader>();

        for(int i = 0; i < policia.paisActual().edificios().size();i++){
            FXMLLoader ventanaEdificio = new FXMLLoader(this.getClass().getResource("VentanaDeEdificio.fxml"));
            ventanaEdificio.load();
            ((ControladorVentanaEdificio) ventanaEdificio.getController())
                .inicializar(policia, policia.paisActual().edificios().get(i), robo, estado, t, selfLoader);
            vistasEdificios.add(ventanaEdificio);
        }

        ((ControladorVentanaOpcionesEdificios)fxmlLoader.getController())
            .inicializar(policia, policia.paisActual(), vistasEdificios);
    }

    public void viajar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeOpcionesViaje" + ".fxml"));
        try {
            raiz.getScene().setRoot(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }

        List<FXMLLoader> vistasPaises = new ArrayList<FXMLLoader>();
        for(int i = 0; i < policia.paisActual().obtenerAdyacentes().size(); i++){
            FXMLLoader ventanaPais = new FXMLLoader(this.getClass().getResource("VentanaDeJuego.fxml"));
            try {
                ventanaPais.load();
                ((ControladorVentanaPais) ventanaPais.getController())
                    .inicializar(policia, policia.paisActual().obtenerAdyacentes().get(i), robo, estado, t, ventanaPais);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            vistasPaises.add(ventanaPais);
        } 
        ((ControladorVentanaOpcionesPais)fxmlLoader.getController())
            .inicializar(policia, policia.paisActual(), vistasPaises, selfLoader);
    }

    public void consultar(){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeComputadora" + ".fxml"));
        
        try {
            Parent padre = fxmlLoader.load();
            raiz.getScene().setRoot(padre);
            ((ControladorVentanaComputadora)fxmlLoader.getController()).inicializar(policia, selfLoader);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public void anotar(){
        /* FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDePistas" + ".fxml"));
        try {
            notas = fxmlLoader.load();
            itemsQuitadosAlAnotar = new ArrayList<>();
            for(Node n : contenedorDerecha.getItems()){
                itemsQuitadosAlAnotar.add(n);
            }
            contenedorDerecha.getItems().clear();
            contenedorDerecha.getItems().add(notas);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        } */
    }

    public void notificarLlegada() throws Exception {
        policia.viajarA(pais);
        actualizarInterfaz();
    }

    public void actualizarInterfaz() throws IOException {
        inicializar(policia, pais, robo, estado, t, selfLoader);
    }

    public void mostrarLadrones() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeLadrones" + ".fxml"));

        try {
            Parent padre = fxmlLoader.load();
            raiz.getScene().setRoot(padre);
            ((ControladorVentanaDeLadrones)fxmlLoader.getController()).inicializar(selfLoader);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
