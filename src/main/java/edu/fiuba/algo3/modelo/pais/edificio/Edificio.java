package edu.fiuba.algo3.modelo.pais.edificio;

import edu.fiuba.algo3.modelo.actividades.EntrarAEdificio;
import edu.fiuba.algo3.modelo.interfaces.IEdificio;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IPista;
import edu.fiuba.algo3.modelo.interfaces.IRelacionConLadron;
import edu.fiuba.algo3.modelo.policia.Policia;

public class Edificio implements IEdificio{

    int cantidadDeVisitas = 0;
    IPais pais;
    String nombre;
    IPista pista;
    IRelacionConLadron relacionConLadron;

    public Edificio(
            String nombre,
            IPais pais,
            IRelacionConLadron relacionConLadron) {
        this.pais = pais;
        this.nombre = nombre;
        this.pista = relacionConLadron.crearPista();
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
    public void entrar(Policia policia) {
        this.relacionConLadron.entrar(policia);

        cantidadDeVisitas ++;

        policia.reportarIngresoAEdificio(new EntrarAEdificio(this.cantidadDeVisitas));

    }

    @Override
    public void asignarPais(IPais pais) {
        this.pais = pais;
    }
}

