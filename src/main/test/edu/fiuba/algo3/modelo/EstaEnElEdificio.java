package edu.fiuba.algo3.modelo;


import java.util.SplittableRandom;

public class EstaEnElEdificio implements IRelacionConLadron {
    @Override
    public void herirConCuchillo(Policia policia) throws Exception {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 5) //probabilidad 5% de que reciba un ataque con cuchillo
            policia.recibirHeridaConCuchillo();
    }

    @Override
    public void herirConArmaDeFuego(Policia policia) throws Exception {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 50) //probabilidad 10% de que reciba un ataque con arma de fuego
            policia.recibirHeridaConArmaDeFuego();
    }
}
