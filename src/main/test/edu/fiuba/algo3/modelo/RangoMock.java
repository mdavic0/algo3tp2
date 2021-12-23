package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.dificultad.Facil;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class RangoMock implements IRango{

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
    public IRango subirRango(int cantidadDeArrestos) {
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        return valor;
    }

    @Override
    public void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador) {
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
