package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class GeneradorDeEdificios implements IGeneradorDeEdificios{
    private FabricaDePistas fabrica;
    private Temporizador temporizador;
    private IRango rango;

    public GeneradorDeEdificios(IRobo robo, Temporizador temporizador, IRango rango) {
        this.fabrica = new FabricaDePistas(robo);
        this.temporizador = temporizador;
        this.rango = rango;
    }

    //TODO: generar distintos tipos de edificios
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
                dificultad, 
                temporizador, 
                pistasDeCadaEdificio[i],
                new NoEstuvoEnEdificio())); //TODO: Que las pistas dependan de la relacion del edificio con el ladron(?
        }
        return edificios;
    }

    @Override
    public List<IEdificio> crearEdificiosPara(IPais pais) throws Exception {
        return crearEdificiosPara(pais, new Facil());
    }
}
