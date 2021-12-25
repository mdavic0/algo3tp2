package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.util.List;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.Policia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class ControladorVentanaOpcionesPais {
    @FXML
    public Button opcion1;
    @FXML
    public Button opcion2;
    @FXML
    public Button opcion3;
    @FXML
    public AnchorPane raiz;

    private Policia paco;
    private List<FXMLLoader> vistas;
    private FXMLLoader ventanaARegresar;
    
    void inicializar(Policia paco, Pais pais, List<FXMLLoader> vistasPaises, FXMLLoader ventanaARegresar){
        this.paco = paco;
        this.vistas = vistasPaises;
        this.ventanaARegresar = ventanaARegresar;

        List<Pais> paises = paco.paisActual().obtenerAdyacentes();
        Button[] botones = {opcion1, opcion2, opcion3};

        for(int i = 0; i < paises.size(); i++){
            atarBotonAPais(paises.get(i), botones[i], vistas.get(i));
            botones[i].setVisible(true);
        }
        for(int i = paises.size(); i < 3; i++){
            botones[i].setVisible(false);
        }
    }

    void atarBotonAPais(Pais pais, Button boton, FXMLLoader vista){
        boton.setText(pais.nombre());
        boton.setOnAction(a -> entrarA(pais, vista));
    }

    void entrarA(Pais pais, FXMLLoader ventanaCargada){
        try {
            ((ControladorVentanaPais)ventanaCargada.getController()).notificarLlegada();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        raiz.getScene().setRoot(ventanaCargada.getRoot());
    }

    public void botonRegresar() throws IOException {
        Parent nodoARegresar = ventanaARegresar.getRoot();
        raiz.getScene().setRoot(nodoARegresar);
    }

}
