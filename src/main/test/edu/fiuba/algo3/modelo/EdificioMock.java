package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;

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
    public String nombre() {
        return nombre;
    }
    @Override
    public Integer cantidadDeVisitas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void entrar(Policia policia) {

    }

    @Override
    public void asignarPais(IPais pais) {
        this.pais = pais;
    }

}
