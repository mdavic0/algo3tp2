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
        return new PaisSinPistas("Chile");
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
    public Pista pistaParaPais(IPais pais) {
        return new Pista(pistaParaPais);
    }

    @Override
    public Pista pistaParaPais(PaisSinPistas pais) {
        return new Pista(pistaParaPais);
    }

    @Override
    public Pista pistaParaLadron() {
        return new Pista(pistaParaLadron);
    }


    public String obtenerPistaParaPais() {
        return this.pistaParaPais;
    }


    public String obtenerPistaParaLadron() {
        return this.pistaParaLadron;
    }

    @Override
    public PaisSinPistas paisDespuesDe(PaisSinPistas pais) {
        return null;
    }
}
