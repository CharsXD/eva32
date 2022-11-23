package com.proyect.eva3.Modelo;

public class Usuario {
    public String key;
    public String Contra;
    public String nombre;
    public String apellido;
    public String Correo;


    public Usuario() {
    }

    public Usuario(String key, String Correo, String nombre, String apellido, String Contra) {
        this.key = key;
        this.Contra = Contra;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "key='" + key + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
