package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robo {
    List<PaisSinPistas> viaSinInit;
    Artefacto artefacto;
    Ladron ladron;
    IGeneradorDeRobo generador = new GeneradorDeRobo();

    public Robo(Dificultad dificultad) throws Exception{
        viaSinInit = generador.viaDePaises(dificultad);
        ladron = generador.generarLadron();
        artefacto = generador.artefacto(dificultad);
    }        

        //TODO: reemplazar uso de 'generador de robo' por uno que genere una instancia de Robo()
    public Robo(Dificultad dificultad, IGeneradorDeRobo generador) throws Exception {
        viaSinInit = generador.viaDePaises(dificultad);
        ladron = generador.generarLadron();
        artefacto = generador.artefacto(dificultad);
    } 

    public Robo(List<PaisSinPistas> via, Ladron ladron, Artefacto artefacto) throws Exception {
        viaSinInit = via;
        this.ladron = ladron;
        this.artefacto = artefacto;
    } 

    //TODO: implementar rango
    public String reportarRobo(Object rango) {
        return "Hola, ".concat(rango.toString()).concat(". Hubo un robo de ").concat(artefacto.toString());
    }

    public PaisSinPistas lugarDeRobo() {
        return viaSinInit.get(0);
    }

    public String nombreDeArtefacto() {
        return artefacto.nombre;
    }

    public Ladron obtenerLadron() {
        return ladron;
    }

    public PaisSinPistas primerPais() {
        return viaSinInit.get(0);
    }

    //TODO: generar distintos tipos de pistas
    public Pista pistaParaPais(IPais pais) {

        PaisSinPistas pedido = viaSinInit
            .stream()
            .filter(p -> pais.nombre() == p.nombre).findFirst().get();
        return pistaParaPais(pedido);
    } 
    
    
    //TODO: generar distintos tipos de pistas
    public Pista pistaParaPais(PaisSinPistas pais) {
        return new Pista(this.paisDespuesDe(pais).nombre);
    } 
    
    //TODO: generar distintos tipos de pistas
    public Pista pistaParaLadron(){
        return new Pista("El genero era ".concat(this.ladron.genero().toString()));
    }

    public PaisSinPistas paisDespuesDe(PaisSinPistas pais) {
        return viaSinInit.get(viaSinInit.indexOf(pais) + 1);
    }
}