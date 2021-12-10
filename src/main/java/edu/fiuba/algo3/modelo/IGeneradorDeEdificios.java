package edu.fiuba.algo3.modelo;
import java.util.List;

public interface IGeneradorDeEdificios {
    List<IEdificio> crearEdificiosPara(IPais pais, Dificultad dificultad) throws Exception;
    List<IEdificio> crearEdificiosPara(IPais pais) throws Exception;

}
