package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    IRobo robo;
    Testigo testigo;
    String nombre;
    ITipoDeEdificio tipoDeEdificio;
    IRelacionConLadron relacionConLadron;

    Temporizador temporizador;

    public Edificio(String nombre, IPais pais, IRobo robo, Temporizador temporizador, ITipoDeEdificio tipoDeEdificio, IRelacionConLadron relacionConLadron){
        this.pais = pais;
        this.nombre = nombre;
        this.tipoDeEdificio = tipoDeEdificio;
        this.relacionConLadron = relacionConLadron;
        this.robo = robo;
        this.testigo = tipoDeEdificio.crearTestigo(robo, pais);
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
    public void entrar(Policia policia) throws Exception {
        this.relacionConLadron.herirConCuchillo(policia); //se delega la cuestion probabilistica, que varia segun si el
        this.relacionConLadron.herirConArmaDeFuego(policia); // ladron estuvo en el edificio

        cantidadDeVisitas ++;

        this.temporizador.reportarActividad(new EntrarAEdificio(cantidadDeVisitas));
    }
}
