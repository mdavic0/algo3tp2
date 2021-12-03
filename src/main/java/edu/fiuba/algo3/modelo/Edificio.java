package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    Robo robo;
    Testigo testigo;
    String nombre;
    TipoDeEdificio tipoDeEdificio;

    public Edificio(String nombre, IPais pais2, Robo robo, TipoDeEdificio unTipo){
        this.pais = pais2;
        this.nombre = nombre;
        this.tipoDeEdificio = unTipo;
        this.robo = robo;
        //posible implementacion: this.testigo = tipoDeEdificio.crearTestigo(robo, pais)
        this.testigo = new Testigo(robo, pais2);
    }

    public String obtenerTestimonio() {
        return this.testigo.cuestionar();
    }

    public IPais obtenerPais() {
        return this.pais;
    }

    public Integer cantidadDeVisitas(){
        return this.cantidadDeVisitas;
    }

    public void nuevaVisita(){
        cantidadDeVisitas ++;
    }

    public String seleccionarPista (){
        return tipoDeEdificio.seleccionarPista();
    }

    public String nombre(){
        return nombre;
    }
}
