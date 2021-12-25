package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.dificultad.Facil;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.policia.elementosDeTrabajo.Temporizador;
import edu.fiuba.algo3.modelo.policia.rangos.Rango;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class RangoMock extends Rango {

    Valor valor;
    IDificultad IDificultad = new Facil();

    public RangoMock(Valor valor) {
        this.valor = valor;
    }

    public RangoMock(IDificultad IDificultad) {
        this.IDificultad = IDificultad;
    }

    @Override
    public IDificultad obtenerDificultadPistas() {
        return IDificultad;
    }

    @Override
    public Rango subirRango(int cantidadDeArrestos) {
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        return valor;
    }

    @Override
    public void reportarViaje(Pais paisActual, Pais paisDestino, Temporizador temporizador) {
    }

    @Override
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
