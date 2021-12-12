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
            otraPropiedad.tipo() == this.tipo 
            && otraPropiedad.contenido() == this.contenido;
        }
    public String contenido() {
        return contenido;
    }
    public String tipo() {
        return tipo;
    }
}
