package edu.fiuba.algo3.modelo.interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.Artefacto;
import edu.fiuba.algo3.modelo.Valor;

public interface IRango {
    IDificultad obtenerDificultadPistas();

    IRango subirRango(int cantidadDeArrestos);

    Valor generarValorDeArtefacto() ;

    void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador);

    Artefacto generarArtefacto(List<Artefacto> artefactos);
}
