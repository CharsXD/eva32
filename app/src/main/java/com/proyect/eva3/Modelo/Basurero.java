package com.proyect.eva3.Modelo;

public class Basurero {
    public String key;
    public String nombre;
    public String porcentaje;
    public String tamaño;

    public Basurero() {
    }


    public Basurero(String key, String nombre, String porcentaje, String tamaño) {
        this.key = key;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.tamaño = tamaño;

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Basurero: " +
                ". . . . . . . . . . . . . . . . . . . . . " +
                "Nombre='" + nombre + '\'' +
                ". . . . . . . . . . . . . . . . . . . ." +
                "Porcentaje='" + porcentaje + '\'' +
                ". . . . . . . . . . . . . . . . . . . ." +
                "Tamaño=" + tamaño +
                ' ';

    }


}
