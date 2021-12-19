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


public class ControladorVentanaOpcionesPais {
    @FXML
    public Button opcion1;
    @FXML
    public Button opcion2;
    @FXML
    public Button opcion3;
    @FXML
    public SplitPane raiz;

    private Policia paco;
    private List<FXMLLoader> vistasEdificios;
    
    void inicializar(Policia paco, IPais pais, List<FXMLLoader> vistasPaises){
        this.paco = paco;
        this.vistasEdificios = vistasPaises;
        List<IPais> paises = paco.paisActual().obtenerAdyacentes();
        Button[] botones = {opcion1, opcion2, opcion3};

        for(int i = 0; i < paises.size(); i++){
            atarBotonAPais(paises.get(i), botones[i], vistasEdificios.get(i));
        }
        
    }

    void atarBotonAPais(IPais pais, Button boton, FXMLLoader vista){
        boton.setText(pais.nombre());
        boton.setOnAction(a -> entrarA(pais, vista));
    }

    void entrarA(IPais pais, FXMLLoader ventanaCargada){
        try {
            ((ControladorVentanaPais)ventanaCargada.getController()).notificarLlegada();
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
