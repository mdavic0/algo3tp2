package edu.fiuba.algo3.modelo;
import java.util.List;

public interface IGeneradorDeEdificios {
    public void crearEdificiosPara(List<IPais> paises, Robo robo, IDificultad d) throws Exception;

}
