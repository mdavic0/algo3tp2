package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{
    IPais pais;
    IRobo robo;
    Testigo testigo;
    String nombre;
    Temporizador temporizador;
    int cantidadDeVisitas;

    public Edificio(String nombre, IPais pais, IRobo robo, Temporizador temporizador){
        this.pais = pais;
        this.nombre = nombre;
        this.robo = robo;
        this.testigo = new Testigo(robo, pais);
        this.temporizador = temporizador;
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

    @Override
    public void entrar() {
        this.temporizador.reportarActividad(new EntrarAEdificio(cantidadDeVisitas));
    }
}
