package edu.fiuba.algo3.modelo;

public class Propiedad {
    private String tipo;
    private String contenido;

    public Propiedad(String tipo, String contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }
    boolean coincidencia(Propiedad otraPropiedad) {
        return 
            otraPropiedad.esDeTipo(this.tipo)
            && otraPropiedad.contenidoIgualA(this.contenido);
        }
    private boolean contenidoIgualA(String contenido2) {
        return contenido.contentEquals(contenido2);
    }
    private boolean esDeTipo(String tipo2) {
        return tipo.contentEquals(tipo2);
    }
}
