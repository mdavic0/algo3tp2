package edu.fiuba.algo3.modelo;

public abstract class Genero { 
    public static Genero aPartirDe(String clave) throws Exception {
        if(clave == "F") {
            return new GeneroFemenino();
        }
        else if(clave == "M") {
            return new GeneroMasculino();
        }
        else throw new Exception("Género desconocido!");
    }
}
