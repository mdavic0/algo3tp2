package edu.fiuba.algo3.modelo.pistas;

public class PistaDeVehiculo extends Pista{
    public PistaDeVehiculo(String vehiculo) {
        this.contenido = this.darFormato(vehiculo);
    }

    @Override
    public String darFormato(String vehiculo) {
        return "Llego conduciendo ".concat(vehiculo).concat(". ");
    }
}
