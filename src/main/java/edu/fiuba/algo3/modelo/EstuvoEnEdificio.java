package edu.fiuba.algo3.modelo;

import java.util.SplittableRandom;

public class EstuvoEnEdificio implements IRelacionConLadron {
    @Override
    public void herirConCuchillo(Policia policia) throws Exception {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 30) //probabilidad 30% de que reciba un ataque con cuchillo
            policia.recibirHeridaConCuchillo();
    }

    @Override
    public void herirConArmaDeFuego(Policia policia) throws Exception {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 15) //probabilidad 15% de que reciba un ataque con arma de fuego
            policia.recibirHeridaConArmaDeFuego();
    }
}