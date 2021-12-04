package edu.fiuba.algo3.modelo;

public class FueraDeEdificio extends LugarActual {

    IPais pais;

<<<<<<< HEAD
    public FueraDeEdificio(IPais pais) {// Pais pais
        this.pais = pais;
=======
    public FueraDeEdificio(IPais colombia) {// Pais pais
        this.pais = colombia;
>>>>>>> experimental
    }

    public LugarActual entrarA(IEdificio unEdificio) throws Exception {
        if(!pais.contieneEdificio(unEdificio))
            throw new Exception("Ese edificio no existe.");
<<<<<<< HEAD

        unEdificio.nuevaVisita();

=======
        unEdificio.entrar();
>>>>>>> experimental
        return new EnEdificio(unEdificio);
    }

    @Override
    public String cuestionarTestigo() throws Exception {
        throw new Exception("No estás en un edificio!");
    }

    @Override
    public FueraDeEdificio viajarA(IPais pais) throws Exception {
        if(this.pais.sePuedeViajarA(pais)) return new FueraDeEdificio(pais);

        throw new Exception("No puedo viajar a ese pais!");
    }

    @Override
    public LugarActual salirDelEdificio() throws Exception {
        return null;
    }

    @Override
    public IPais obtenerPais() {
        return this.pais;
    }

<<<<<<< HEAD
    //TODO quitar argumento
=======
>>>>>>> experimental
    @Override
    public LugarActual salirDe(Edificio edificio) throws Exception {
        throw new Exception("Ya estas afuera");
    }

}
