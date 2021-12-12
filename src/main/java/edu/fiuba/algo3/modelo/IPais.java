package edu.fiuba.algo3.modelo;
import java.util.List;

public interface IPais { 

    List<IEdificio> edificios(IEdificio edificio);

    void agregarEdificios(IEdificio... edificio);
    
    Boolean contieneEdificio(IEdificio edificio);

    void conectarA(IPais otro) ;

    boolean sePuedeViajarA(IPais pais) ;

    String nombre();

    double obtenerLatitud();

    double obtenerLongitud();

    double distanciaA(IPais paisDestino);

    String moneda();

    //Object hechoHistorico();
}
