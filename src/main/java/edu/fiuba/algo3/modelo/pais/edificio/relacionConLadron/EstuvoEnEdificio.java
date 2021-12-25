package edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron;

import java.util.SplittableRandom;

import edu.fiuba.algo3.modelo.interfaces.IRelacionConLadron;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.policia.Policia;

public class EstuvoEnEdificio implements IRelacionConLadron {
    private Pista pista;

    public EstuvoEnEdificio(Pista pista) {
        this.pista = pista;
    }

    @Override
    public void herirConCuchillo(Policia policia) {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 30) //probabilidad 30% de que reciba un ataque con cuchillo
            policia.recibirHeridaConCuchillo();
    }

    @Override
    public void herirConArmaDeFuego(Policia policia) {
        SplittableRandom aleatorio = new SplittableRandom();
        if(aleatorio.nextInt(1, 101) <= 15) //probabilidad 15% de que reciba un ataque con arma de fuego
            policia.recibirHeridaConArmaDeFuego();
    }

    @Override
    public void entrar(Policia policia){
        herirConCuchillo(policia); //se delega la cuestion probabilistica, que varia segun si el
        herirConArmaDeFuego(policia); // ladron estuvo en el edificio
    }

    @Override
    public Pista crearPista() {
        return this.pista;
    }
}