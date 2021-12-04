package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    IRobo robo;
    Testigo testigo;
    String nombre;
<<<<<<< HEAD
    TipoDeEdificio tipoDeEdificio;

    public Edificio(String nombre, IPais pais2, Robo robo, TipoDeEdificio unTipo){
        this.pais = pais2;
=======
    Temporizador temporizador;
    int cantidadDeVisitas;

    public Edificio(String nombre, IPais pais, IRobo robo, Temporizador temporizador){
        this.pais = pais;
>>>>>>> experimental
        this.nombre = nombre;
        this.tipoDeEdificio = unTipo;
        this.robo = robo;
<<<<<<< HEAD
        //posible implementacion: this.testigo = tipoDeEdificio.crearTestigo(robo, pais)
        this.testigo = new Testigo(robo, pais2);
=======
        this.testigo = new Testigo(robo, pais);
        this.temporizador = temporizador;
>>>>>>> experimental
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

    @Override
    public void entrar() {
        this.temporizador.reportarActividad(new EntrarAEdificio(cantidadDeVisitas));
    }
}
