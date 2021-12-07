package edu.fiuba.algo3.modelo;

public class Detective implements IRango {
    double velocidadKmh;
    Dificultad dificultad;

    public Detective(){
        this.velocidadKmh = 1100;
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
            return new Investigador();
        }
        return this;
    }
    @Override
    public Valor generarValorDeArtefacto() {
        return new Valioso();
    }

    @Override
    public void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador) {
        Viajar actividad = new Viajar(paisActual, paisDestino, this.velocidadKmh);
        actividad.reportar(temporizador);
    }
}
