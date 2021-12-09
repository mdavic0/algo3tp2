package edu.fiuba.algo3.modelo;
import java.util.List;

public interface IPais { 

    public List<IEdificio> edificios(IEdificio edificio);

    public void agregarEdificio(IEdificio edificio);
    
    public Boolean contieneEdificio(IEdificio edificio);

    public void conectarA(IPais otro) ;

    public boolean sePuedeViajarA(IPais pais) ;

    public String nombre();

    double obtenerLatitud();
    double obtenerLongitud();
    double distanciaA(IPais paisDestino);

    public PaisSinPistas sinPistas() throws Exception;

    public String moneda();

    public Object hechoHistorico();
}
