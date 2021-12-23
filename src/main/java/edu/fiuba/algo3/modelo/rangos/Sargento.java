package edu.fiuba.algo3.modelo.rangos;

import java.util.Collections;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.actividades.Viajar;
import edu.fiuba.algo3.modelo.dificultad.Dificil;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Sargento implements IRango {
    double velocidadKmh;
    IDificultad IDificultad;

    public Sargento(){
        this.velocidadKmh = 1500;
        this.IDificultad = new Dificil();
    }

    @Override
    public IDificultad obtenerDificultadPistas(){
        return IDificultad;
    }

    @Override
    public IRango subirRango(int cantidadDeArrestos) {
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 90) //probabilidad 90% de que genere un valor MuyValioso
            return new MuyValioso();
        return new Valioso(); // ==> 10% de que genere un valor Valioso
    }

    @Override
    public void reportarViaje(IPais paisActual, IPais paisDestino, ITemporizador temporizador) {
        Viajar actividad = new Viajar(paisActual, paisDestino, this.velocidadKmh);
        actividad.reportar(temporizador);
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
