package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robo implements IRobo {
    List<PaisSinPistas> viaSinInit;
    Artefacto artefacto;
    Ladron ladron;

    public Robo(List<PaisSinPistas> via, Ladron ladron, Artefacto artefacto) throws Exception {
        viaSinInit = via;
        this.ladron = ladron;
        this.artefacto = artefacto;
    } 

    //TODO: implementar rango
    @Override
    public String reportarRobo(Object rango) {
        return "Hola, ".concat(rango.toString()).concat(". Hubo un robo de ").concat(artefacto.toString());
    }

    @Override
    public PaisSinPistas lugarDeRobo() {
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
    public PaisSinPistas primerPais() {
        return viaSinInit.get(0);
    }
    
    @Override
    public PaisSinPistas paisDespuesDe(IPais paisDelTestigo) {
        PaisSinPistas pedido = viaSinInit
            .stream()
            .filter(p -> paisDelTestigo.nombre() == p.nombre).findFirst().get();
       
        return viaSinInit.get(viaSinInit.indexOf(pedido) + 1);
    }
}