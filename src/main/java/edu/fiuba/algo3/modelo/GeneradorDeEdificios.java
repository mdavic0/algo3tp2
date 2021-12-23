package edu.fiuba.algo3.modelo;
import java.util.List;

import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IGeneradorDeEdificios;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRango;
import edu.fiuba.algo3.modelo.interfaces.IRobo;

import java.util.ArrayList;

public class GeneradorDeEdificios implements IGeneradorDeEdificios{
    private final IRobo robo;
    private final IDificultad dificultad;

    public GeneradorDeEdificios(IRobo robo, IRango rango) {
        this.robo = robo;
        this.dificultad = rango.obtenerDificultadPistas();
    }

    public void crearEdificiosPara(List<IPais> paises, Robo robo) {
        for(IPais p : paises){
                if(!robo.viaSinInit.contains(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeNoEstuvoLadron(p));
                }
                else if (robo.ubicacionDelLadron().equals(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeEstaLadron(p));
                }
                else {
                    //OBS: ACA EN REALIDAD HAY QUE PASARLE EL PAIS AL QUE VA EL LADRON
                    // YA QUE SE AGREGAN EDIFICIOS AL PAIS P, PERO LAS PISTAS SON SOBRE EL PAIS (P + 1)
                    p.agregarEdificios(this.generarParaPaisDondeEstuvoLadron(p, robo.viaSinInit.get(robo.viaSinInit.indexOf(p) + 1)));
                }
        };
    }

    private List<IEdificio> generarParaPaisDondeEstuvoLadron(IPais paisActual, IPais paisSiguiente) {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", paisActual, new EstuvoEnEdificio(this.dificultad.crearPistaEconomica(paisSiguiente, robo.obtenerLadron()))));
        edificios.add(new Edificio("Aeropuerto", paisActual, new EstuvoEnEdificio(this.dificultad.crearPistaDeViaje(paisSiguiente, robo.obtenerLadron()))));
        edificios.add(new Edificio("Museo", paisActual, new EstuvoEnEdificio(this.dificultad.crearPistaHistorica(paisSiguiente, robo.obtenerLadron()))));
        return edificios;
    }

    private List<IEdificio> generarParaPaisDondeEstaLadron(IPais pais) {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", pais, new EstaEnElEdificioDeAlLado()));
        edificios.add(new Edificio("Aeropuerto", pais, new EstaEnElEdificioDeAlLado()));
        edificios.add(new Edificio("Biblioteca", pais, new EstaEnElEdificio(robo.obtenerLadron())));
        return edificios;
    }

    private List<IEdificio> generarParaPaisDondeNoEstuvoLadron(IPais pais) {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", pais, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Aeropuerto", pais, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Biblioteca", pais, new NoEstuvoEnEdificio()));
        return edificios;
    }
}
