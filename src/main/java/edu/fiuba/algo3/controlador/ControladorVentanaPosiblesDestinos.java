package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.Policia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.List;

public class ControladorVentanaPosiblesDestinos {
    @FXML
    public Button opcion1;
    @FXML
    public Button opcion2;
    @FXML
    public Button opcion3;
    @FXML
    public AnchorPane raiz;

    private FXMLLoader ventanaARegresar;

    void inicializar(FXMLLoader ventanaARegresar, Policia policia){
        this.ventanaARegresar = ventanaARegresar;

        List<Pais> paises = policia.paisActual().obtenerAdyacentes();
        Button[] botones = {opcion1, opcion2, opcion3};

        for(int i = 0; i < paises.size(); i++){
            atarBotonAPais(paises.get(i), botones[i]);
            botones[i].setVisible(true);
        }
        for(int i = paises.size(); i < 3; i++){
            botones[i].setVisible(false);
        }
    }

    void atarBotonAPais(Pais pais, Button boton){
        boton.setText(pais.nombre());
    }

    public void botonRegresar() throws IOException {
        Parent nodoARegresar = ventanaARegresar.getRoot();
        raiz.getScene().setRoot(nodoARegresar);
    }

}
