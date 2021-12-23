package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interfaces.IDificultad;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IPista;
import edu.fiuba.algo3.modelo.robo.Ladron;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Comun;
import edu.fiuba.algo3.modelo.robo.artefacto.valor.Valor;

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
