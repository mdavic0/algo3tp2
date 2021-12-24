package edu.fiuba.algo3.modelo.policia.rangos;

import java.util.Collections;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.actividades.Viajar;
import edu.fiuba.algo3.modelo.dificultad.Media;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.interfaces.ITemporizador;
import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.MuyValioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valioso;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

public class Investigador extends Rango {

    public Investigador(){
        this.velocidadKmh = 1300;
        this.IDificultad = new Media();
    }

    @Override
    public IRango subirRango(int cantidadDeArrestos) {
        if(cantidadDeArrestos %5 == 0){
            return new Sargento();
        }
        return this;
    }

    @Override
    public Valor generarValorDeArtefacto() {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 50) //probabilidad 50% de que genere un valor Valioso
            return new Valioso();
        return new MuyValioso(); // ==> 50% de que genere un valor MuyValioso
    }

}
