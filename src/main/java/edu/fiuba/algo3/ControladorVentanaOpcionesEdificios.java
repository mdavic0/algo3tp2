package edu.fiuba.algo3;

import java.io.IOException;
import java.util.List;

import edu.fiuba.algo3.modelo.GeneradorDeEdificios;
import edu.fiuba.algo3.modelo.IEdificio;
import edu.fiuba.algo3.modelo.IPais;
import edu.fiuba.algo3.modelo.Policia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;


public class ControladorVentanaOpcionesEdificios {
    @FXML
    public Button opcion1;
    @FXML
    public Button opcion2;
    @FXML
    public Button opcion3;
    @FXML
    public SplitPane raiz;

    private Policia paco;
    private FXMLLoader actual;
    private FXMLLoader previo;
    private List<FXMLLoader> vistasEdificios;
    
    void inicializar(Policia paco, IPais pais, FXMLLoader actual, FXMLLoader previo, List<FXMLLoader> vistasEdificios){
        this.paco = paco;
        this.actual = actual;
        this.previo = previo;
        this.vistasEdificios = vistasEdificios;
        List<IEdificio> edificios = pais.edificios();

        atarBotonAEdificio(edificios.get(0), opcion1, vistasEdificios.get(0));
    }

    void atarBotonAEdificio(IEdificio edificio, Button boton, FXMLLoader vista){
        boton.setText(edificio.nombre());
        boton.setOnAction(a -> entrarA(edificio, vista));
    }

    void entrarA(IEdificio edificio, FXMLLoader ventanaCargada){
        try {
            ((ControladorVentanaEdificio)ventanaCargada.getController()).notificarEntrada();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        for(Node node : raiz.getItems()){
            node.setVisible(false);
        }

        raiz.getItems().clear();
        raiz.getItems().add(ventanaCargada.getRoot());
    }
}