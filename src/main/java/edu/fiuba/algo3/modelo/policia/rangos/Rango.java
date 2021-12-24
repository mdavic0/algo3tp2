package edu.fiuba.algo3.modelo.policia.rangos;

import edu.fiuba.algo3.modelo.actividades.Viajar;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Rango {
    double velocidadKmh;
    IDificultad IDificultad;

    public IDificultad obtenerDificultadPistas(){
        return IDificultad;
    }
    public abstract Rango subirRango(int cantidadDeArrestos);
    public abstract Valor generarValorDeArtefacto();

    public void reportarViaje(Pais paisActual, Pais paisDestino, Temporizador temporizador) {
        Viajar actividad = new Viajar(paisActual, paisDestino, this.velocidadKmh);
        actividad.reportar(temporizador);
    }

    public Artefacto generarArtefacto(List<Artefacto> artefactos) {
        Valor v = this.generarValorDeArtefacto(); // se genera con una cuestion probabilistica que depende del rango.

        List<Artefacto> candidatos =  artefactos
                .stream()
                //obtener artefacto del valor requerido
                .filter(artef ->
                        artef.valor().getClass() == v.getClass()
                )
                .collect(Collectors.toList());

        Collections.shuffle(candidatos);
        return candidatos.get(0);
    }
}
