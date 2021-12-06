package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.Integer;

public interface IGeneradorDeEdificios {
    List<IEdificio> crearEdificiosPara(IPais pais, Dificultad dificultad) throws Exception;
    List<IEdificio> crearEdificiosPara(IPais pais) throws Exception;

}
