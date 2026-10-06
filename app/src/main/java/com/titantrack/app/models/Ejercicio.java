package com.titantrack.app.models;

public class Ejercicio {

    private String nombre;
    private String grupoMuscular;
    private String series;
    private String nivel;

    public Ejercicio(String nombre, String grupoMuscular, String series, String nivel) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public String getSeries() { return series; }
    public String getNivel() { return nivel; }
}