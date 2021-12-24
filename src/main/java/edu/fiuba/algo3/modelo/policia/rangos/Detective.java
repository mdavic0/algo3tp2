package edu.fiuba.algo3.modelo.policia.rangos;

import java.util.SplittableRandom;
import edu.fiuba.algo3.modelo.dificultad.Facil;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Detective extends Rango {

    public Detective(){
        this.velocidadKmh = 1100;
        this.IDificultad = new Facil();
    }

    @Override
    public Rango subirRango(int cantidadDeArrestos) {
        if(cantidadDeArrestos %5 == 0){
            return new Investigador();
        }
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 60) //probabilidad 60% de que genere un valor Valioso
            return new Valioso();
        return new Comun(); // ==> 40% de que genere un valor Comun
    }
}
