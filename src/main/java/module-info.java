module edu.fiuba.algo3 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;
    requires json.simple;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.excepciones;
    exports edu.fiuba.algo3.modelo.interfaces;
    exports edu.fiuba.algo3.controlador;
    exports edu.fiuba.algo3.modelo.pistas;
    exports edu.fiuba.algo3.modelo.actividades;
    exports edu.fiuba.algo3.modelo.rangos;
    exports edu.fiuba.algo3.modelo.dificultad;
    exports edu.fiuba.algo3.modelo.policia;
    exports edu.fiuba.algo3.modelo.policia.elementosDeTrabajo;
    exports edu.fiuba.algo3.modelo.robo;
    exports edu.fiuba.algo3.modelo.robo.artefacto;
    exports edu.fiuba.algo3.modelo.robo.artefacto.valor;
    exports edu.fiuba.algo3.modelo.pais;
    exports edu.fiuba.algo3.modelo.pais.lugarActual;
    exports edu.fiuba.algo3.modelo.pais.edificio;
    exports edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron;
}