package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class GeneradorDeEdificios implements IGeneradorDeEdificios{
    private IRango rango;
    private IRobo robo;

    public GeneradorDeEdificios(IRobo robo, IRango rango) {
        this.robo = robo;
        this.rango = rango;
    }

    public void crearEdificiosPara(List<IPais> paises, Robo robo, IDificultad IDificultad) throws Exception {
        for(IPais p : paises){
                if(!robo.viaSinInit.contains(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeNoEstuvoLadron(p));
                }
                else if (robo.ubicacionDelLadron().equals(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeEstaLadron(p));
                }
                else {
                    p.agregarEdificios(this.generarParaPaisDondeEstuvoLadron(p, IDificultad));
                }
        };
    }

    private List<IEdificio> generarParaPaisDondeEstuvoLadron(IPais pais, IDificultad IDificultad) throws Exception {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", pais, new EstuvoEnEdificio(IDificultad.crearPistaEconomica(pais, robo.obtenerLadron()))));
        edificios.add(new Edificio("Aeropuerto", pais, new EstuvoEnEdificio(IDificultad.crearPistaDeViaje(pais, robo.obtenerLadron()))));
        edificios.add(new Edificio("Museo", pais, new EstuvoEnEdificio(IDificultad.crearPistaHistorica(pais, robo.obtenerLadron()))));
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
