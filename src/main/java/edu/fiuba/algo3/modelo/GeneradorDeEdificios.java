package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class GeneradorDeEdificios implements IGeneradorDeEdificios{
    private FabricaDePistas fabrica;
    private Temporizador temporizador;

    public GeneradorDeEdificios(IRobo robo, Temporizador temporizador) {
        this.fabrica = new FabricaDePistas(robo);
        this.temporizador = temporizador;
        
    }

    //TODO: generar distintos tipos de edificios
    public List<IEdificio> crearEdificiosPara(IPais pais, Dificultad dificultad) throws Exception{
        
        IPista[] pistasDeCadaEdificio =  {
            fabrica.crearPistaEconomica(pais, dificultad), 
            fabrica.crearPistaDeLectura(pais, dificultad), 
            fabrica.crearPistaDeViaje(pais, dificultad),
        };
        
        List<IEdificio> edificios = new ArrayList<IEdificio>();
        for(int i = 1; i <= 3; i++){
            String nombre = "Edificio".concat(Integer.toString(i));
            edificios.add(new Edificio(
                nombre, pais, 
                dificultad, 
                temporizador, 
                pistasDeCadaEdificio[i]));
        }
        return edificios;
    }

    @Override
    public List<IEdificio> crearEdificiosPara(IPais pais) throws Exception {
        return crearEdificiosPara(pais, new Facil());
    }
}
