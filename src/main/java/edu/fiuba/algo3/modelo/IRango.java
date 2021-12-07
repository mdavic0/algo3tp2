package edu.fiuba.algo3.modelo;

public interface IRango {
    double velocidadKmh();

    Dificultad obtenerDificultadPistas();

    IRango subirRango();

    Valor generarValorDeArtefacto() ;

    void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador);
}
