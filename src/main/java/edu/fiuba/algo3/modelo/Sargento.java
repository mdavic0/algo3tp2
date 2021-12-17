package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class Sargento implements IRango {
    double velocidadKmh;
    Dificultad dificultad;

    public Sargento(){
        this.velocidadKmh = 1500;
        this.dificultad = new Dificil();
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
