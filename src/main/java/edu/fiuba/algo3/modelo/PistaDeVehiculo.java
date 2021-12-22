package edu.fiuba.algo3.modelo;

public class PistaDeVehiculo extends Pista{
    public PistaDeVehiculo(String vehiculo) {
        this.contenido = this.darFormato(vehiculo);
    }

    @Override
    String darFormato(String vehiculo) {
        return "Llego conduciendo ".concat(vehiculo);
    }
}