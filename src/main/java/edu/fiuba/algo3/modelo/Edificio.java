package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    IRobo robo;
    Testigo testigo;
    String nombre;
    TipoDeEdificio tipoDeEdificio;
    Temporizador temporizador;

    public Edificio(String nombre, IPais pais, IRobo robo, Temporizador temporizador, TipoDeEdificio edificio){
        this.pais = pais;
        this.nombre = nombre;
        this.tipoDeEdificio = new EdificioEconomico();
        this.robo = robo;
        //posible implementacion: this.testigo = tipoDeEdificio.crearTestigo(robo, pais)
        this.testigo = new Testigo(robo, pais);
        this.temporizador = temporizador;
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

    public String seleccionarPista (){
        return tipoDeEdificio.seleccionarPista();
    }

    public String nombre(){
        return nombre;
    }

    @Override
    public void entrar() { //TODO recibir como parametro al policia
        //if(me da la gana())
        //    paco.heridaDeCuchillo
        cantidadDeVisitas ++;
        this.temporizador.reportarActividad(new EntrarAEdificio(cantidadDeVisitas));
    }
}
