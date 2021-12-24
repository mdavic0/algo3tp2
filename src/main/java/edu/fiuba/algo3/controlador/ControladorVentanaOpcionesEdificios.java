package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.util.List;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class ControladorVentanaOpcionesEdificios {
    @FXML
    public Button opcion1;

    @FXML
    public Button opcion2;

    @FXML
    public Button opcion3;

    @FXML
    public AnchorPane raiz;

    private Policia paco;
    private List<FXMLLoader> vistasEdificios;
    private FXMLLoader ventanaARegresar;

    void inicializar(Policia paco, Pais pais, List<FXMLLoader> vistasEdificios, FXMLLoader ventanaARegresar){
        this.paco = paco;
        this.vistasEdificios = vistasEdificios;
        this.ventanaARegresar = ventanaARegresar;
        List<Edificio> edificios = pais.edificios();
        Button[] botones = {opcion1, opcion2, opcion3};

        for(int i = 0; i < edificios.size(); i++){
            atarBotonAEdificio(edificios.get(i), botones[i], vistasEdificios.get(i));
        }
    }

    void atarBotonAEdificio(Edificio edificio, Button boton, FXMLLoader vista){
        boton.setText(edificio.nombre());
        boton.setOnAction(a -> entrarA(edificio, vista));
    }

    void entrarA(Edificio edificio, FXMLLoader ventanaCargada){
        try {
            ((ControladorVentanaEdificio)ventanaCargada.getController()).notificarEntrada();
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
