package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRobo;

public class RoboMock implements IRobo{

    @Override
    public String reportarRobo(Object rango) {
        return null;
    }

    @Override
    public Pais lugarDeRobo() throws Exception {
        return new Pais("Chile", 0, 0);
    }

    @Override
    public String nombreDeArtefacto() {
        return null;
    }

    @Override
    public Ladron obtenerLadron() {
        return null;
    }

    @Override
    public Pais primerPais() {
        return null;
    }

    @Override
    public Pais paisDespuesDe(IPais paisDelTestigo) throws Exception{
        return new Pais("PaisMock", 0, 0);
    }

}
