package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class GeneradorDeEdificios implements IGeneradorDeEdificios{
    private FabricaDePistas fabrica;
    private IRango rango;
    private IRobo robo;

    public GeneradorDeEdificios(IRobo robo, ITemporizador temporizador, IRango rango) {
        this.fabrica = new FabricaDePistas(robo);
        this.robo = robo;
        this.rango = rango;
    }

    //TODO: generar distintos tipos de edificios
    @Deprecated
    public List<IEdificio> crearEdificiosPara(IPais pais, Dificultad dificultad) throws Exception{
        
        IPista[] pistasDeCadaEdificio =  {
            fabrica.crearPistaEconomica(pais, rango), 
            fabrica.crearPistaDeLectura(pais, rango), 
            fabrica.crearPistaDeViaje(pais, rango),
        };
        
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        for(int i = 0; i < 3; i++){
            String nombre = "Edificio".concat(Integer.toString(i+1));
            edificios.add(new Edificio(
                nombre, pais,
                new NoEstuvoEnEdificio()));
        }
        return edificios;
    }

    @Deprecated
    public List<IEdificio> crearEdificiosPara(IPais pais) throws Exception {
        return crearEdificiosPara(pais, new Facil());
    }

    public void crearEdificiosPara(List<IPais> paises, Robo robo, Dificultad d) throws Exception {
        for(IPais p : paises){
                if(!robo.viaSinInit.contains(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeNoEstuvoLadron(p));
                }
                else if (robo.ubicacionDelLadron().equals(p)) {
                    p.agregarEdificios(this.generarParaPaisDondeEstaLadron(p, robo));
                }
                else {
                    p.agregarEdificios(this.generarParaPaisDondeEstuvoLadron(p, d));
                }
        };
    }

    private List<IEdificio> generarParaPaisDondeEstuvoLadron(IPais p, Dificultad d) throws Exception {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", p, new EstuvoEnEdificio(fabrica.crearPistaDeLadron(d))));
        edificios.add(new Edificio("Aeropuerto", p, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Migraciones", p, new NoEstuvoEnEdificio()));
        return edificios;
    }

    private List<IEdificio> generarParaPaisDondeEstaLadron(IPais p, Robo robo) {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", p, new EstaEnElEdificioDeAlLado()));
        edificios.add(new Edificio("Aeropuerto", p, new EstaEnElEdificioDeAlLado()));
        edificios.add(new Edificio("Migraciones", p, new EstaEnElEdificio(robo.obtenerLadron())));
        return edificios;
    }

    private List<IEdificio> generarParaPaisDondeNoEstuvoLadron(IPais p) {
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        edificios.add(new Edificio("Banco", p, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Aeropuerto", p, new NoEstuvoEnEdificio()));
        edificios.add(new Edificio("Migraciones", p, new NoEstuvoEnEdificio()));
        return edificios;
    }
}
