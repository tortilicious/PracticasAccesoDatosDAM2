package org.example;

public class Persona {
    private int edad;
    private String nombre;
    private String apellido;
    private int dni;

    public Persona() {
    }

    public Persona(int edad, String nombre, String apellido, int dni) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
