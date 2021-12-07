package edu.fiuba.algo3.modelo;

public interface IRango {
    double velocidadKmh();

    Dificultad obtenerDificultadPistas();

    IRango subirRango(int cantidadDeArrestos);

    Valor generarValorDeArtefacto() ;

    void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador);
}
