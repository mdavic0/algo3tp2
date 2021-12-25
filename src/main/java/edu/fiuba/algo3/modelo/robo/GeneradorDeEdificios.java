package edu.fiuba.algo3.modelo.robo;
import java.util.List;
import java.util.SplittableRandom;
import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.EstaEnElEdificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.EstaEnElEdificioDeAlLado;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.EstuvoEnEdificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.NoEstuvoEnEdificio;
import edu.fiuba.algo3.modelo.policia.rangos.Rango;

import java.util.ArrayList;

public class GeneradorDeEdificios{
    private IDificultad dificultad;
    private Robo robo;

    public GeneradorDeEdificios(Rango rango) {
        this.dificultad = rango.obtenerDificultadPistas();
    }

    public void crearEdificiosPara(List<Pais> paises, Robo robo) {
        this.robo = robo;
        for(Pais p : paises){
                if(!robo.viaSinInit.contains(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeNoEstuvoLadron(p));
                }
                else if (robo.ubicacionDelLadron().equals(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeEstaLadron(p));
                }
                else {
                    p.agregarEdificios(this.generarParaPaisDondeEstuvoLadron(
                        p, 
                        robo.viaSinInit.get(robo.viaSinInit.indexOf(p) + 1)));
                }
        };
    }

    private List<Edificio> generarParaPaisDondeEstuvoLadron(Pais paisActual, Pais paisSiguiente) {
        List<Edificio> edificios = new ArrayList<Edificio>();

        SplittableRandom aleatorio = new SplittableRandom();
        int n =aleatorio.nextInt(1, 101);
        if(n < 50){
            edificios.add(new Edificio("Banco", paisActual, new EstuvoEnEdificio(
                this.dificultad.crearPistaEconomica(paisSiguiente, robo.obtenerLadron()))));
            edificios.add(new Edificio("Aeropuerto", paisActual, new EstuvoEnEdificio(
                this.dificultad.crearPistaDeViaje(paisSiguiente, robo.obtenerLadron()))));
            edificios.add(new Edificio("Museo", paisActual, new EstuvoEnEdificio(
                this.dificultad.crearPistaHistorica(paisSiguiente, robo.obtenerLadron()))));
        }
        else{
            edificios.add(new Edificio("Banco", paisActual, new EstuvoEnEdificio(
                this.dificultad.crearPistaEconomica(paisSiguiente, robo.obtenerLadron()))));
            edificios.add(new Edificio("Puerto", paisActual, new EstuvoEnEdificio(
                this.dificultad.crearPistaDeViaje(paisSiguiente, robo.obtenerLadron()))));
            edificios.add(new Edificio("Migraciones", paisActual, new EstuvoEnEdificio(
                this.dificultad.crearPistaHistorica(paisSiguiente, robo.obtenerLadron()))));
        }
        
        return edificios;
    }

    private List<Edificio> generarParaPaisDondeEstaLadron(Pais pais) {
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(new Edificio("Banco", pais, new EstaEnElEdificioDeAlLado()));
        edificios.add(new Edificio("Aeropuerto", pais, new EstaEnElEdificioDeAlLado()));
        edificios.add(new Edificio("Biblioteca", pais, new EstaEnElEdificio(robo.obtenerLadron())));
        return edificios;
    }

    private List<Edificio> generarParaPaisDondeNoEstuvoLadron(Pais pais) {
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(new Edificio("Banco", pais, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Aeropuerto", pais, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Biblioteca", pais, new NoEstuvoEnEdificio()));
        return edificios;
    }
}
