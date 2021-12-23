package edu.fiuba.algo3.modelo.rangos;

import java.util.Collections;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.actividades.Viajar;
import edu.fiuba.algo3.modelo.dificultad.Facil;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Novato implements IRango {

    double velocidadKmh;
    IDificultad IDificultad;

    public Novato(){
        this.velocidadKmh = 900;
        this.IDificultad = new Facil();
    }
    
    @Override
    public IDificultad obtenerDificultadPistas(){
        return IDificultad;
    }

    @Override
    public IRango subirRango(int cantidadDeArrestos) {
        if(cantidadDeArrestos %5 == 0){
            return new Detective();
        }
        return this;

    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 80) //probabilidad 80% de que genere un valor Comun
            return new Comun();
        return new Valioso(); // ==> 20% de que genere un valor Valioso
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
