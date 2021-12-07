package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    String nombre;
    IPista pista;
    ITemporizador temporizador;
    IRelacionConLadron relacionConLadron;

    public Edificio(
            String nombre,
            IPais pais,
            Dificultad dificultad,
            ITemporizador temporizador,
            IPista pista,
            IRelacionConLadron relacionConLadron) {
        this.pais = pais;
        this.nombre = nombre;
        this.pista = pista;
        this.temporizador = temporizador;
        this.relacionConLadron = relacionConLadron;
    }

    public String obtenerTestimonio() {
        return pista.contenido();
    }

    public IPais obtenerPais() {
        return this.pais;
    }

    public Integer cantidadDeVisitas(){
        return this.cantidadDeVisitas;
    }

    public String nombre(){
        return nombre;
    }

    @Override
    public void entrar(Policia policia) throws Exception {
        this.relacionConLadron.herirConCuchillo(policia); //se delega la cuestion probabilistica, que varia segun si el
        this.relacionConLadron.herirConArmaDeFuego(policia); // ladron estuvo en el edificio

        cantidadDeVisitas ++;

        EntrarAEdificio e = new EntrarAEdificio(cantidadDeVisitas);
        e.reportar(this.temporizador);
    }
}

