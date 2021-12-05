package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;

public class GeneradorDeRobo implements IGeneradorDeRobo {
    Valor[] valores = {new MuyValioso(),  new Valioso(),new ValorMedio()};

    public Robo generarRobo(Dificultad d, IRango rango, LectorDeArchivo lector) throws Exception {
        Artefacto artefacto = generarArtefacto(rango, lector.obtenerArtefactos());
        List<PaisSinPistas> via = generarEscapeParaArtefacto(lector, artefacto);
        Ladron ladron = generarLadron(lector.obtenerLadrones());
        return new Robo(via, ladron, artefacto);
    }

    private List<PaisSinPistas> generarEscapeParaArtefacto(LectorDeArchivo lector, Artefacto artefacto) throws Exception {
        for(int i = 0; i < valores.length; i++){
            if(artefacto.valor().getClass() == valores[i].getClass())
                return generarViaDeEscape(lector.obtenerPaises(), artefacto.valor().cantidadDePaises());
        }
        throw new Exception("No se reconoce el valor del artefacto.");
    }

    private Artefacto generarArtefacto(IRango rango, List<Artefacto> artefactos) {
        Valor v = rango.generarValorDeArtefacto();
        List<Artefacto> candidatos =  artefactos
            .stream()
            //obtener artefacto del calor requerido
            .filter(artef -> 
                artef.valor().getClass() == v.getClass() 
            )
            .collect(Collectors.toList());

        Collections.shuffle(candidatos);
        return candidatos.get(0);
    }

    private Ladron generarLadron(List<Ladron> ladrones) {
        Collections.shuffle(ladrones);
        return ladrones.get(0);
    }

    private List<PaisSinPistas> generarViaDeEscape(List<PaisSinPistas> paises, int cantidad) {
        Collections.shuffle(paises);
        return paises.subList(0, cantidad);
    }
}
