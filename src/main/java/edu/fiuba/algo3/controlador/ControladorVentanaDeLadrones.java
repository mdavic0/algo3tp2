package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentanaDeLadrones {
    @FXML
    public AnchorPane raiz;

    @FXML
    public Label ladron1;

    @FXML
    public Label ladron2;

    @FXML
    public Label ladron3;

    @FXML
    public Label ladron4;

    @FXML
    public Label ladron5;

    @FXML
    public Label ladron6;

    @FXML
    public Label ladron7;

    @FXML
    public Label ladron8;

    @FXML
    public Label ladron9;

    @FXML
    public Label ladron10;

    private FXMLLoader ventanaARegresar;

    public void inicializar(FXMLLoader ventanaARegresar) {
        this.ventanaARegresar = ventanaARegresar;

        ladron1.setText("nombre: \"Carmen Sandiego\".\n" +
                "genero: Femenino\".\n" +
                "ocupacion: \"Antigua gente del Servicio de Espionaje de Mónaco\".\n" +
                "hobby: \"Tenis\".\n" +
                "cabello: \"Castaño\".\n" +
                "vehiculo: \"un Descapotable Packard 1939\",\n" +
                "senia: \"Jamás se muestra en público sin su collar de rubíes\".\n" +
                "otros: \"Le encanta la enchilada\".");

        ladron2.setText("nombre: \"Merey LaRoc\".\n" +
                "genero: \"Femenino\".\n" +
                "ocupacion: \"Bailarina profesional de aerobic\".\n" +
                "hobby: \"Alpinismo\".\n" +
                "cabello: \"Castaño\".\n" +
                "vehiculo: \"una Limusina de lujo\".\n" +
                "senia: \"Siempre lleva unas joyas muy elegantes\".\n" +
                "otros: \"Le encanta la comida picante\".");

        ladron3.setText("nombre: \"Dazzle Annie Nonker\".\n" +
                "genero: \"Femenino\".\n" +
                "ocupacion: \"Propietaria de un bar de yogurt\".\n" +
                "hobby: \"Tenis\".\n" +
                "cabello: \"Rubio\".\n" +
                "vehiculo: \"una Limusina Bugatti\".\n" +
                "senia: \"Se rumorea que tiene un tatuaje\".\n" +
                "otros: \"Le encanta comer marisco\".");

        ladron4.setText("nombre: \"Lady Agatha Wayland\".\n" +
                "genero: \"Femenino\".\n" +
                "ocupacion: \"Lectora de novelas de misterio\".\n" +
                "hobby: \"Tenis\",\n" +
                "cabello: \"Rojizo\".\n" +
                "vehiculo: \"un Deportivo Denghby\".\n" +
                "senia: \"LLeva un anillo con un diamante del tamaño de una uva\".\n" +
                "otros: \"Atraviesa los campos en busca de restaurantes mejicanos\".");

        ladron5.setText("nombre: \"Len 'Red' Bulk\".\n" +
                "genero: \"Masculino\".\n" +
                "ocupacion\": \"Ex-jugador de hockey profesional\".\n" +
                "hobby: \"Alpinismo\".\n" +
                "cabello: \"Rojizo\".\n" +
                "vehiculo\": \"un Descapotable\".\n" +
                "senia: \"Tiene una sirena tatuada en el pulgar de la mano derecha\".\n" +
                "otros: \"Le encanta el marisco\".");

        ladron6.setText("nombre: \"Scar Graynolt\".\n" +
                "genero: \"Masculino\".\n" +
                "ocupacion: \"Guitarrista folk\".\n" +
                "hobby: \"Croquet\".\n" +
                "cabello: \"Rojizo\".\n" +
                "vehiculo: \"una Limusina de ventanas oscuras\".\n" +
                "senia: \"Lleva un anillo de oro de cinco quilates\".\n" +
                "otros: \"Tiene un fiel servidor sherpa de 2'15 metros\".");

        ladron7.setText("nombre: \"Nick Brunch\".\n" +
                "genero: \"Masculino\".\n" +
                "ocupacion: \"Ex-detective privado\".\n" +
                "hobby: \"Alpinismo\".\n" +
                "cabello: \"Negro\".\n" +
                "vehiculo: \"una Moto Kamikaze-1250\".\n" +
                "senia: \"Lleva gabardina y sombrero. Ojos marrones y bigote\".\n" +
                "otros: \"Le apasiona la cocina mejicana; lleva un anillo de Dick Tracy\".");

        ladron8.setText("nombre: \"Fast Eddie B.\",\n" +
                "genero: \"Masculino\".\n" +
                "ocupacion: \"Jugador mundial de croquet\".\n" +
                "hobby: \"Croquet\".\n" +
                "cabello: \"Negro\".\n" +
                "vehiculo: \"un Descapotable\".\n" +
                "senia: \"Siempre deja un alfiler de diamantes en la escena del crimen\".\n" +
                "otros: \"Siempre va impecablemente vestido y peinado; le encanta la comida mejicana\".");

        ladron9.setText("nombre: \"Ihor Ihorovitch\".\n" +
                "genero: \"Masculino\".\n" +
                "ocupacion: \"Aspirante al trono zarista\".\n" +
                "hobby: \"Croquet\".\n" +
                "cabello: \"Rubio\".\n" +
                "vehiculo: \"una Limusina\".\n" +
                "senia: \"Tiene un extraño tatuaje ucraniano en el hombro derecho\".\n" +
                "otros: \"Le encanta comer langosta y ver dibujos animados\".");

        ladron10.setText("nombre: \"Katherine Drib\".\n" +
                "genero: \"Femenino\".\n" +
                "ocupacion: \"Piloto de carreras de motociclismo\".\n" +
                "hobby: \"Alpinismo\".\n" +
                "cabello: \"Castaño\".\n" +
                "vehiculo: \"una Moto Honda 1000\".\n" +
                "senia: \"Lleva el tatuaje de un águila en el brazo izquierdo\".\n" +
                "otros: \"Cocina muy bien el marisco; es una fanatica de la salud y del aerobic\".");
    }

    public void botonRegresar() throws IOException {
        Parent nodoARegresar = ventanaARegresar.getRoot();
        raiz.getScene().setRoot(nodoARegresar);
    }
}
