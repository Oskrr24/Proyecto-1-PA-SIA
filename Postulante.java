//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.HashMap;

class Postulante{
    private int edad;
    private String nombre;
    private String apellido;
    private String rut;
    private boolean esIndigena;

    public Postulante(int edad, String nombre, String apellido, String rut){
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }

    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }

    public String getRut(){
        return rut;
    }
    
}

