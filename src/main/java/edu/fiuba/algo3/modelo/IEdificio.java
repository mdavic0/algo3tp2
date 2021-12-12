package edu.fiuba.algo3.modelo;

public interface IEdificio {
    public String obtenerTestimonio();
    public IPais obtenerPais() ;
    public Object nombre();
    public Integer cantidadDeVisitas();
    void entrar(Policia policia) throws Exception;
    void asignarPais(IPais pais);
}
