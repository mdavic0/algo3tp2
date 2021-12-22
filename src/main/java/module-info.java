module edu.fiuba.algo3 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;
    requires json.simple;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.excepciones;
    exports edu.fiuba.algo3.controlador;
}