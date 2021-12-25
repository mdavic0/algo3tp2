package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pais.edificio.Edificio;
import edu.fiuba.algo3.modelo.pais.edificio.relacionConLadron.NoEstuvoEnEdificio;
import edu.fiuba.algo3.modelo.policia.Policia;

public class EdificioMock extends Edificio {
    Pais pais;
    String pista;
    String nombre;

    public EdificioMock(String nombre){
        super(nombre, null, new NoEstuvoEnEdificio());
        this.nombre = nombre;
        this.pista = "YO NO VI NADA!";
    }

    public EdificioMock(String nombre, String pista){
        super(nombre, null, new NoEstuvoEnEdificio());
        this.nombre = nombre;
        this.pista = pista;
    }

    public Pais obtenerPais() {
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
    public void asignarPais(Pais pais) {
        this.pais = pais;
    }

}
