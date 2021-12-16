package edu.fiuba.algo3.modelo;

public class Temporizador implements ITemporizador {
    int hora_inicial;
    int horas_transcurridas;
    int hora_dormir;
    int horas_de_sueño = 8;
    int hora_limite;

    //TODO: reemplazar con patron de estado
    String estado = "Activo";

    public Temporizador(int hora_inicial ,int hora_dormir, int hora_limite) {
        this.hora_inicial = hora_inicial;
        horas_transcurridas = 0;
        this.hora_dormir = hora_dormir;
        this.hora_limite = hora_limite;
    }

    @Override
    public int horaActual(){
        return (hora_inicial + horas_transcurridas) % 24;
    }

    @Override
    public int horasTranscurridas(){
        return horas_transcurridas;
    }

    private String aumentarHoraActual(int hora_a_agregar){
        horas_transcurridas +=hora_a_agregar;
        if(horaActual() >= hora_dormir) {
            //Nota: hacer esto un evento que sea notificado al policia y al UI
            horas_transcurridas += horas_de_sueño;
        }
        if(horasTranscurridas() >= hora_limite) {
            //nota: reemplazar con patron de estado y hacer evento
            return "Inactivo";
        }
        return "Activo";
    }

    @Override
    public void reportarActividad(int duracion) {
        estado = aumentarHoraActual(duracion);
    }
}