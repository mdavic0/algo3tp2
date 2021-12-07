package edu.fiuba.algo3.modelo;

public class Novato implements IRango {
    double velocidadKmh;
    Dificultad dificultad;

    public Novato(){
        this.velocidadKmh = 900;
        this.dificultad = new Facil();
    }

    @Override
    public double velocidadKmh() {
        return velocidadKmh;
    }

    @Override
    public Dificultad obtenerDificultadPistas(){
        return dificultad;
    }

    @Override
    public IRango subirRango(int cantidadDeArrestos) {
        if(cantidadDeArrestos %5 == 0){
            return new Detective();
        }
        return this;

    }

    @Override
    public Valor generarValorDeArtefacto() {
        return new ValorMedio();
    }

    @Override
    public void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador) {
        Viajar actividad = new Viajar(paisActual, paisDestino, this.velocidadKmh);
        actividad.reportar(temporizador);
    }
}
