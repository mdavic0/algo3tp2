package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.HashMap;


public enum DiccionarioDeDias {
    LUNES(0, "Lunes"),
    MARTES(1, "Martes"),
    MIERCOLES(2, "Miercoles"),
    JUEVES(3, "Jueves"),
    VIERNES(4, "Viernes"),
    SABADO(5, "Sabado"),
    DOMINGO(6, "Domingo");

    private static final HashMap<Integer, DiccionarioDeDias> enumById = new HashMap<>();
    static {
        Arrays.stream(values()).forEach(e -> enumById.put(e.getId(), e));
    }

    private final int id;
    private final String descripcion;

    DiccionarioDeDias(int id, String dia) {
        this.id = id;
        this.descripcion= dia;
    }

    public int getId() {
        return id;
    }

    public String dia() {
        return descripcion;
    }

    public static DiccionarioDeDias getById(int id) {
        return enumById.get(id);
    }


}
