package edu.fiuba.algo3.modelo;

public class PistaDeDatoCurioso extends Pista{
    public PistaDeDatoCurioso(String datoCurioso) {
        this.contenido = this.darFormato(datoCurioso);
    }
    @Override
    String darFormato(String datoCurioso) {
        return "El pais al que se dirigia es conocido por ".concat(datoCurioso).concat(".");
    }
}
