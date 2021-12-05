package edu.fiuba.algo3.modelo;

public class RangoMock implements IRango{
    Valor valor;
    public RangoMock(Valor valor) {
        this.valor = valor;
    }
    @Override
    public double velocidadKmh() {
        return 100;
    }
    @Override
    public Dificultad obtenerDificultadPistas() {
        return new Facil();
    }
    @Override
    public IRango subirRango() {
        return this;
    }
    @Override
    public Valor generarValorDeArtefacto() {
        return valor;
    }

    
   
}
