package edu.fiuba.algo3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentanaPuntajes  implements Initializable {

    @FXML
    public Label puntajesMasAltos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntajesMasAltos.setText(this.leerArchivo());
    }

    public void botonRegresar() {
        System.out.print("Regresar");
    }

    private String leerArchivo(){

        String top20 = "TOP 20 AGENTES DE LA INTERPOL:\n\n" + "NOMBRE, RANGO, N° ARRESTOS\n";
        try {
            FileReader reader = new FileReader("src/main/resources/edu/fiuba/algo3/top20policias.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String linea;
            int posicion = 1;
            while ((linea = bufferedReader.readLine()) != null && (posicion <= 20)) {
                top20 += "\n" + String.valueOf(posicion++).concat(") " + linea) ;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return top20;
    }

}
