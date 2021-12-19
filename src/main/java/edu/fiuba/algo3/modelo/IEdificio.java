package edu.fiuba.algo3.modelo;

public interface IEdificio {
    public String obtenerTestimonio();
    public IPais obtenerPais() ;
    public String nombre();
    public Integer cantidadDeVisitas();
    void entrar(Policia policia);
    void asignarPais(IPais pais);
}
