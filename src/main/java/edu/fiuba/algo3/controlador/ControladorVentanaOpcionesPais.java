package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private List<FXMLLoader> vistas;
    
    void inicializar(Policia paco, IPais pais, List<FXMLLoader> vistasPaises){
        this.paco = paco;
        this.vistas = vistasPaises;
        List<IPais> paises = paco.paisActual().obtenerAdyacentes();
        Button[] botones = {opcion1, opcion2, opcion3};

        for(int i = 0; i < paises.size(); i++){
            atarBotonAPais(paises.get(i), botones[i], vistas.get(i));
            botones[i].setVisible(true);
        }
        for(int i = paises.size(); i < 3; i++){
            botones[i].setVisible(false);
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
        raiz.getScene().setRoot(ventanaCargada.getRoot());
    }
}
