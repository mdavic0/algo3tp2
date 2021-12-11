package edu.fiuba.algo3.modelo;

public class EdificioMock implements IEdificio{
    IPais pais;
    String pista;
    String nombre;

    public EdificioMock(String nombre){
        this.nombre = nombre;
        this.pista = "YO NO VI NADA!";
    }

    public EdificioMock(String nombre, String pista){
        this.nombre = nombre;
        this.pista = pista;
    }

    public IPais obtenerPais() {
       return this.pais;
    }

    @Override
    public String obtenerTestimonio() {
        return this.pista;
    }

    @Override
    public Object nombre() {
        return nombre;
    }
    @Override
    public Integer cantidadDeVisitas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void entrar(Policia policia) throws Exception {

    }

    @Override
    public void asignarPais(IPais pais) {
        this.pais = pais;
    }

}
