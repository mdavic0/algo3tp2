package edu.fiuba.algo3.modelo.policia.rangos;

import java.util.SplittableRandom;
import edu.fiuba.algo3.modelo.dificultad.Media;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Investigador extends Rango {
    private int VELOCIDAD = 1300;
    private static int CANTIDAD_MINIMA_ARRESTOS = 5;
    private static int probabilidadValioso = 50;
    public Investigador(){
        this.velocidadKmh = VELOCIDAD;
        this.IDificultad = new Media();
    }

    @Override
    public Rango subirRango(int cantidadDeArrestos) {
        if(cantidadDeArrestos %CANTIDAD_MINIMA_ARRESTOS == 0){
            return new Sargento();
        }
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= probabilidadValioso) //probabilidad 50% de que genere un valor Valioso
            return new Valioso();
        return new MuyValioso(); // ==> 50% de que genere un valor MuyValioso
    }

}
