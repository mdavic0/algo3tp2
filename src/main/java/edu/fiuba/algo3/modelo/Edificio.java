package edu.fiuba.algo3.modelo;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    String nombre;
    IPista pista;
    ITemporizador temporizador;

    public Edificio(
            String nombre,
            IPais pais,
            Dificultad dificultad,
            ITemporizador temporizador,
            IPista pista) {
        this.pais = pais;
        this.nombre = nombre;
        this.pista = pista;
        this.temporizador = temporizador;
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
    public void entrar() { //TODO recibir como parametro al policia
        //if(me da la gana())
        //    paco.heridaDeCuchillo
        cantidadDeVisitas ++;
        this.temporizador.reportarActividad(new EntrarAEdificio(cantidadDeVisitas));
    }
}
