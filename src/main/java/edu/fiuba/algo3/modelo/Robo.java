package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Robo implements IRobo {
    List<IPais> viaSinInit;
    Artefacto artefacto;
    Ladron ladron;

    public Robo(List<IPais> via, List<IPais> paisesPosibles, Ladron ladron, Artefacto artefacto) throws Exception {
        viaSinInit = via;
        this.ladron = ladron;
        this.artefacto = artefacto;
        this.generarConexionesEntrePaises(via, paisesPosibles);
    } 

    private void generarConexionesEntrePaises(List<IPais> via, List<IPais> paisesPosibles) throws Exception {
        if (via.size() >= paisesPosibles.size()) 
            throw new Exception("Necesito más paises incorrectos que correctos para generar el juego!");

        //TODO conectar paises bidireccionalmente
        IntStream.range(0,via.size()-1).forEach(
            i -> via.get(i).conectarA(via.get(i+1))
        );

        List<IPais> paisesIncorrectos = paisesPosibles.stream()
            .filter(p -> !via.contains(p))
            .collect(Collectors.toList());
        IntStream
            .range(0, via.size())
            .forEach(i -> 
                via.get(i).conectarA(
                    paisesIncorrectos.get(i % paisesIncorrectos.size())
                )
            );
    }

    //TODO: implementar rango
    @Override
    public String reportarRobo(Object rango) {
        return "Hola, ".concat(rango.toString()).concat(". Hubo un robo de ").concat(artefacto.toString());
    }

    @Override
    public IPais lugarDeRobo() {
        return viaSinInit.get(0);
    }

    @Override
    public String nombreDeArtefacto() {
        return artefacto.nombre;
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
}