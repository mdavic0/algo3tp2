package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IPista;

public class DificultadMock implements IDificultad {
    Valor v = new Comun();

    public DificultadMock() {}
    public DificultadMock(Valor v) {
        this.v = v;
    }
    public Valor generarValorDeArtefacto() {
        return v;
    }

    @Override
    public IPista crearPistaEconomica(IPais pais, Ladron ladron) {
        return new PistaMock("Pista!");
    }

    @Override
    public IPista crearPistaHistorica(IPais pais, Ladron ladron) {
        return new PistaMock("Pista!");
    }

    @Override
    public IPista crearPistaDeViaje(IPais pais, Ladron ladron) {
        return new PistaMock("Pista!");
    }
}
