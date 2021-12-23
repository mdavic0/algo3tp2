package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IRango {
    IDificultad obtenerDificultadPistas();

    IRango subirRango(int cantidadDeArrestos);

    Valor generarValorDeArtefacto() ;

    void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador);

    Artefacto generarArtefacto(List<Artefacto> artefactos);
}
