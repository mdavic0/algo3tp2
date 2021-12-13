package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class GeneradorDeRobo implements IGeneradorDeRobo {
    Valor[] valores = {new MuyValioso(),  new Valioso(),new ValorMedio()};

    public Robo generarRobo(IRango rango, List<Artefacto> artefactos, List<IPais> paisesPosibles, List<Ladron> ladrones) throws Exception {
        Artefacto artefacto = generarArtefacto(rango, artefactos);
        List<IPais> via = generarEscapeParaArtefacto(paisesPosibles, artefacto);
        Ladron ladron = generarLadron(ladrones);
        return new Robo(via, paisesPosibles, ladron, artefacto);
    }

    private List<IPais> generarEscapeParaArtefacto(List<IPais> paises, Artefacto artefacto) throws Exception {
        for(int i = 0; i < valores.length; i++){
            if(artefacto.valor().getClass() == valores[i].getClass())
                return generarViaDeEscape(paises, artefacto.valor().cantidadDePaises());
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

    private List<IPais> generarViaDeEscape(List<IPais> paises, int cantidad) {
        Collections.shuffle(paises);
        return paises.subList(0, cantidad);
    }
}
