package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public interface IPais { 

    public List<IEdificio> edificios(IEdificio edificio);

    public void agregarEdificio(IEdificio edificio);
    
    public Boolean contieneEdificio(IEdificio edificio);

    public void conectarA(IPais otro) ;

    public boolean sePuedeViajarA(IPais pais) ;

    public Object nombre();

    int obtenerCoordenadaX();
    int obtenerCoordenadaY();
    int distanciaA(IPais paisDestino);
}
