package edu.fiuba.algo3.modelo.pais.edificio;

import edu.fiuba.algo3.modelo.actividades.EntrarAEdificio;
import edu.fiuba.algo3.modelo.interfaces.IRelacionConLadron;
import edu.fiuba.algo3.modelo.pais.Pais;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.policia.Policia;

public class Edificio {

    int cantidadDeVisitas = 0;
    Pais pais;
    String nombre;
    Pista pista;
    IRelacionConLadron relacionConLadron;

    public Edificio(
            String nombre,
            Pais pais,
            IRelacionConLadron relacionConLadron) {
        this.pais = pais;
        this.nombre = nombre;
        this.pista = relacionConLadron.crearPista();
        this.relacionConLadron = relacionConLadron;
    }

    public String obtenerTestimonio() {
        return pista.contenido();
    }

    public Pais obtenerPais() {
        return this.pais;
    }

    public Integer cantidadDeVisitas(){
        return this.cantidadDeVisitas;
    }

    public String nombre(){
        return nombre;
    }

    public void entrar(Policia policia) {
        this.relacionConLadron.entrar(policia);

        cantidadDeVisitas ++;

        policia.reportarIngresoAEdificio(new EntrarAEdificio(this.cantidadDeVisitas));

    }

    public void asignarPais(Pais pais) {
        this.pais = pais;
    }
}

