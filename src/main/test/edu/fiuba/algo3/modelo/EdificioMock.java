package edu.fiuba.algo3.modelo;

public class EdificioMock implements IEdificio{
    String nombre;

    public EdificioMock(String nombre){
        this.nombre = nombre;
    }

    public IPais obtenerPais() {
        try {
            return new PaisMock("California");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String obtenerTestimonio() {
        return "YO NO VI NADA!";
    }

    @Override
    public Object nombre() {
        return nombre;
    }
    @Override
    public Integer cantidadDeVisitas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void entrar(Policia policia) throws Exception {

    }

}
