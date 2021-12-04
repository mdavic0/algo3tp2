package edu.fiuba.algo3.modelo;

public interface IEdificio {
    public String obtenerTestimonio();
    public IPais obtenerPais() ;
    public Object nombre();
    public void nuevaVisita();
    public Integer cantidadDeVisitas();

    void entrar();
}
