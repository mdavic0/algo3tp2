package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{
    IPais pais;
    Robo robo;
    Testigo testigo;
    String nombre;

    public Edificio(String nombre, IPais pais, Robo robo){
        this.pais = pais;
        this.nombre = nombre;
        this.robo = robo;
        this.testigo = new Testigo(robo, pais);
    }

    public String obtenerTestimonio() {
        return this.testigo.cuestionar();
    }

    public IPais obtenerPais() {
        return this.pais;
    }

    public String nombre(){
        return nombre;
    }
}
