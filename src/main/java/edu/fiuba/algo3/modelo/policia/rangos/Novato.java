package edu.fiuba.algo3.modelo.policia.rangos;

import java.util.SplittableRandom;

import edu.fiuba.algo3.modelo.dificultad.Facil;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Novato extends Rango {
    private static int VELOCIDAD = 900;
    private static int CANTIDAD_MINIMA_ARRESTOS = 5;
    private static int probabilidadComun = 80;
    public Novato(){
        this.velocidadKmh = VELOCIDAD;
        this.IDificultad = new Facil();
    }


    @Override
    public Rango subirRango(int cantidadDeArrestos) {
        if(cantidadDeArrestos >= CANTIDAD_MINIMA_ARRESTOS){
            return new Detective();
        }
        return this;

    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= probabilidadComun) //probabilidad 80% de que genere un valor Comun
            return new Comun();
        return new Valioso(); // ==> 20% de que genere un valor Valioso
    }

}
