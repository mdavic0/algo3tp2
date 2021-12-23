package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private List<FXMLLoader> vistasEdificios;
    
    void inicializar(Policia paco, IPais pais, List<FXMLLoader> vistasEdificios){
        this.paco = paco;
        this.vistasEdificios = vistasEdificios;
        List<IEdificio> edificios = pais.edificios();
        Button[] botones = {opcion1, opcion2, opcion3};

        for(int i = 0; i < edificios.size(); i++){
            atarBotonAEdificio(edificios.get(i), botones[i], vistasEdificios.get(i));
        }
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

        raiz.getScene().setRoot(ventanaCargada.getRoot());
    }
}
