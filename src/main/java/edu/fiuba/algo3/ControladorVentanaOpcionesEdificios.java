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
    
    void inicializar(Policia paco, IPais pais){
        this.paco = paco;
        List<IEdificio> edificios = pais.edificios();

        atarBotonAEdificio(edificios.get(0), opcion1);
    }

    void atarBotonAEdificio(IEdificio edificio, Button boton){
        boton.setText(edificio.nombre());
        boton.setOnAction(a -> entrarA(edificio));
    }

    void entrarA(IEdificio edificio){
        try {
            paco.entrarA(edificio);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VentanaDeOpciones" + ".fxml"));
        for(Node node : raiz.getItems()){
            node.setVisible(false);
        }
        try {
            raiz.getItems().add(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
        ((ControladorVentanaEdificio)fxmlLoader.getController()).inicializar(paco, edificio, robo, policia.paisActual());
    }
}
