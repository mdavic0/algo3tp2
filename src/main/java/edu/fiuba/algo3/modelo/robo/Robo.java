package edu.fiuba.algo3.modelo.robo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.fiuba.algo3.modelo.robo.artefacto.Artefacto;
import edu.fiuba.algo3.modelo.excepciones.CantidadDePaisesException;
import edu.fiuba.algo3.modelo.interfaces.IPais;
import edu.fiuba.algo3.modelo.interfaces.IRobo;

public class Robo implements IRobo {
    List<IPais> viaSinInit;
    Artefacto artefacto;
    Ladron ladron;

    public Robo(List<IPais> via, List<IPais> paisesPosibles, Ladron ladron, Artefacto artefacto) throws CantidadDePaisesException {
        viaSinInit = via;
        this.ladron = ladron;
        this.artefacto = artefacto;
        this.generarConexionesEntrePaises(via, paisesPosibles);
    } 

    void conectarBidireccionalmente(IPais pais1, IPais pais2){
        pais1.conectarA(pais2);
        pais2.conectarA(pais1);
    }

    private void generarConexionesEntrePaises(List<IPais> via, List<IPais> paisesPosibles) throws CantidadDePaisesException {
        if (paisesPosibles.size() < 3 * via.size()) 
            throw new CantidadDePaisesException("Necesito el doble de paises incorrectos vs. correctos para generar el robo!");

        IntStream.range(0,via.size()-1).forEach(
            i -> {
                via.get(i).conectarA( via.get(i+1));
            }
        );

        List<IPais> paisesIncorrectos = paisesPosibles.stream()
            .filter(p -> !via.contains(p))
            .collect(Collectors.toList());

        List<IPais> paisesConectadosAVia = new ArrayList<>();
        paisesConectadosAVia.addAll(paisesIncorrectos.subList(0, 2*via.size()));
        List<IPais> paisesNoConectados = new ArrayList<>();
        paisesNoConectados.addAll(paisesIncorrectos.subList(2*via.size(),paisesIncorrectos.size()));

        IntStream
            .range(0, via.size())
            .forEach(i -> 
                {
                    conectarBidireccionalmente(via.get(i), paisesConectadosAVia.get(2*i));
                    conectarBidireccionalmente(via.get(i), paisesConectadosAVia.get(2*i + 1));
                });

        //TODO Conectar paises incorrectos entre si
        /* IntStream
        .range(0, paisesConectadosAVia.size())
        .forEach(i -> 
            {
                conectarBidireccionalmente(
                    paisesConectadosAVia.get(i),
                    paisesNoConectados.get(2*i));
                conectarBidireccionalmente(
                    paisesConectadosAVia.get(i),
                    paisesNoConectados.get(2*i + 1));
                conectarBidireccionalmente(
                    paisesNoConectados.get(2*i),
                    paisesNoConectados.get(2*i + 1));
            }); */
    }

    @Override
    public String reportarRobo(Object rango) {
        return "Hola, ".concat(rango.toString()).concat(". Hubo un robo de ").concat(artefacto.nombre());
    }

    @Override
    public IPais lugarDeRobo() {return viaSinInit.get(0);}

    @Override
    public String nombreDeArtefacto() {
        return artefacto.nombre();
    }

    @Override
    public Ladron obtenerLadron() {
        return ladron;
    }

    @Override
    public IPais primerPais() {
        return viaSinInit.get(0);
    }
    
    @Override
    public IPais paisDespuesDe(IPais paisDelTestigo) {
        IPais pedido = viaSinInit
            .stream()
            .filter(p -> paisDelTestigo==p).findFirst().get();
       
        return viaSinInit.get(viaSinInit.indexOf(pedido) + 1);
    }

    public Object ubicacionDelLadron() {
        return viaSinInit.get(viaSinInit.size() - 1);
    }

    public List<IPais> viaSinInit() {
        return this.viaSinInit;
    }
}