package edu.fiuba.algo3.modelo;

public class RoboMock implements IRobo{

    String pistaParaPais;
    String pistaParaLadron;

    public RoboMock(String pistaParaPais, String pistaParaLadron){
        this.pistaParaPais = pistaParaPais;
        this.pistaParaLadron = pistaParaLadron;
    }

    @Override
    public String reportarRobo(Object rango) {
        return null;
    }

    @Override
    public PaisSinPistas lugarDeRobo() throws Exception {
        return new PaisSinPistas("Chile", "Euro", 0, 0);
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
    public PaisSinPistas primerPais() {
        return null;
    }

    @Override
    public PaisSinPistas paisDespuesDe(IPais paisDelTestigo) throws Exception{
        return new PaisSinPistas("PaisMock","MonedaMock", 0, 0);
    }

}
