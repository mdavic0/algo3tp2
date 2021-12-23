package edu.fiuba.algo3.modelo.interfaces;
import java.util.List;

import edu.fiuba.algo3.modelo.pistas.Pista;

public interface IPais { 

    List<IEdificio> edificios();

    void agregarEdificios(IEdificio... edificio);
    
    Boolean contieneEdificio(IEdificio edificio);

    void conectarA(IPais otro) ;

    boolean sePuedeViajarA(IPais pais) ;

    String nombre();

    double obtenerLatitud();

    double obtenerLongitud();

    double distanciaA(IPais paisDestino);

    void agregarEdificios(List<IEdificio> edificios);

    Pista crearPistaEconomica();

    Pista crearPistaHistorica();

    Pista crearPistaDeViaje();

    List<IPais> obtenerAdyacentes();
}
