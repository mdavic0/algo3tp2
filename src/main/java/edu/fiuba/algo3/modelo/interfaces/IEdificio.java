package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.Policia;

public interface IEdificio {
    public String obtenerTestimonio();
    public IPais obtenerPais() ;
    public String nombre();
    public Integer cantidadDeVisitas();
    void entrar(Policia policia);
    void asignarPais(IPais pais);
}
