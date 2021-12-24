package edu.fiuba.algo3.modelo.policia.rangos;

import java.util.SplittableRandom;
import edu.fiuba.algo3.modelo.dificultad.Dificil;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Sargento extends Rango {
    static int VELOCIDAD = 1500;
    static int PROBABILIDAD = 90;
    public Sargento(){
        this.velocidadKmh = VELOCIDAD;
        this.IDificultad = new Dificil();
    }

    @Override
    public Rango subirRango(int cantidadDeArrestos) {
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= PROBABILIDAD) //probabilidad 90% de que genere un valor MuyValioso
            return new MuyValioso();
        return new Valioso(); // ==> 10% de que genere un valor Valioso
    }

}
