package edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron;

import java.util.SplittableRandom;

import edu.fiuba.algo3.modelo.interfaces.IRelacionConLadron;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.pistas.PistaLadronEstaCerca;
import edu.fiuba.algo3.modelo.policia.Policia;

public class EstaEnElEdificioDeAlLado implements IRelacionConLadron {
    @Override
    public void herirConCuchillo(Policia policia) {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 10) //probabilidad 10% de que reciba un ataque con cuchillo
            policia.recibirHeridaConCuchillo();
    }

    @Override
    public void herirConArmaDeFuego(Policia policia){
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 80) //probabilidad 80% de que reciba un ataque con arma de fuego
            policia.recibirHeridaConArmaDeFuego();
    }

    @Override
    public void entrar(Policia policia){
        herirConCuchillo(policia); //se delega la cuestion probabilistica, que varia segun si el
        herirConArmaDeFuego(policia); // ladron estuvo en el edificio
    }

    @Override
    public Pista crearPista() {
        return new PistaLadronEstaCerca();
    }
}
