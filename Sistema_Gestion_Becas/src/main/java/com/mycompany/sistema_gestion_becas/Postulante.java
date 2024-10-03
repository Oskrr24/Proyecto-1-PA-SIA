package com.mycompany.sistema_gestion_becas;
import java.util.*;
import java.util.InputMismatchException;

public class Postulante {
    private String nombre;
    private String apellido;
    private int edad;
    private String rut;
    private int sexo; // 1 = MASCULINO, 2 = FEMENINO
    private float notasMedia;
    private boolean nacionalidadChilena;
    private int rangoSE;
    private boolean esIndigena;
    private int puntajePaes;
    private String carreraEnCurso;
    private boolean titulado; 
    
    public Postulante(String nombre, String apellido, int edad, String rut, int sexo, float notasMedia, boolean nacionalidadChilena, int rangoSE, boolean esIndigena, int puntajePaes, String carreraEnCurso, boolean titulado){
        setEdad(edad);
        setApellido(apellido);
        setNombre(nombre);
        setRut(rut);
        setSexo(sexo);
        setNotasMedia(notasMedia);
        setNacionalidadChilena(nacionalidadChilena);
        setRangoSE(rangoSE);
        setEsIndigena(esIndigena);
        setPuntajePaes(puntajePaes);
        setCarreraEnCurso(carreraEnCurso);
        setTitulado(titulado);

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
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }

    public String getRut(){
        return this.rut;
    }
    
    public int getSexo() {
        return this.sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public float getNotasMedia() {
        return this.notasMedia;
    }

    public void setNotasMedia(float notasMedia) {
        this.notasMedia = notasMedia;
    }

    public boolean getNacionalidadChilena() {
        return this.nacionalidadChilena;
    }

    public void setNacionalidadChilena(boolean nacionalidadChilena) {
        this.nacionalidadChilena = nacionalidadChilena;
    }

    public float getRangoSE() {
        return this.rangoSE;
    }

    public void setRangoSE(int rangoSE) {
        this.rangoSE = rangoSE;
    }

    public boolean getEsIndigena() {
     return this.esIndigena;
    }

    public void setEsIndigena(boolean esIndigena) {
        this.esIndigena = esIndigena;
    }

    public int getPuntajePaes() {
        return this.puntajePaes;
    }

    public void setPuntajePaes(int puntajePaes) {
        this.puntajePaes = puntajePaes;
    }

    public String getCarreraEnCurso() {
        return this.carreraEnCurso;
    }

    public void setCarreraEnCurso(String carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }

    public boolean getTitulado() {
        return this.titulado;
    }

    public void setTitulado(boolean titulado) {
        this.titulado = titulado;
    }
    
    public static Postulante crearPostulante() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Ingrese el nombre:");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el apellido:");
            String apellido = sc.nextLine();

            System.out.println("Ingrese la edad:");
            int edad = sc.nextInt();
            if (edad < 0 || edad > 120) {
                throw new IllegalArgumentException("La edad ingresada no es válida.");
            }

            sc.nextLine();

            System.out.println("Ingrese el RUT:");
            String rut = sc.nextLine();
            

            System.out.println("Ingrese el sexo (1 para Masculino, 2 para Femenino):");
            int sexo = sc.nextInt();
            if (sexo != 1 && sexo != 2) {
                throw new InputMismatchException("Debe ingresar 1 para Masculino o 2 para Femenino.");
            }

            System.out.println("Ingrese la nota media:");
            float notasMedia = sc.nextFloat();
            if (notasMedia < 1.0 || notasMedia > 7.0) {
                throw new IllegalArgumentException("La nota media debe estar entre 1.0 y 7.0.");
            }

            System.out.println("¿Es de nacionalidad Chilena? (true/false):");
            boolean nacionalidadChilena = sc.nextBoolean();

            System.out.println("Ingrese el rango socioeconómico:");
            int rangoSE = sc.nextInt();
            if (rangoSE < 0 || rangoSE > 100) {
                throw new IllegalArgumentException("El rango socioeconómico debe estar entre 0 y 100.");
            }

            System.out.println("¿Es indígena? (true/false):");
            boolean esIndigena = sc.nextBoolean();

            System.out.println("Ingrese el puntaje PAES:");
            int puntajePaes = sc.nextInt();
            if (puntajePaes < 0 || puntajePaes > 1000) {
                throw new IllegalArgumentException("El puntaje PAES debe estar entre 0 y 1000.");
            }

            sc.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese la carrera en curso:");
            String carreraEnCurso = sc.nextLine();

            System.out.println("¿Está titulado? (true/false):");
            boolean titulado = sc.nextBoolean();

            return new Postulante(nombre, apellido, edad, rut, sexo, notasMedia, nacionalidadChilena, rangoSE, esIndigena, puntajePaes, carreraEnCurso, titulado);
            
        } catch (InputMismatchException e) {
            System.out.println("Error de formato: " + e.getMessage());
            sc.nextLine(); // Limpiar buffer en caso de error
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada inválida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }

        return null; 
    }

    public void mostrarDetalles() {
       System.out.println("Nombre: " + nombre + " " + apellido + ", RUT: " + rut);
    }
    
    public void mostrarDetalles(String formato) {
        if (formato.equals("completo")) {
    System.out.println("Nombre: " + nombre + " " + apellido);
    System.out.println("RUT: " + rut);
    System.out.println("Edad: " + edad);
    System.out.println("Sexo: " + (sexo == 1 ? "Masculino" : "Femenino"));
    System.out.println("Notas promedio: " + notasMedia);
    System.out.println("Nacionalidad chilena: " + (nacionalidadChilena ? "Sí" : "No"));
    System.out.println("Rango socioeconómico: " + rangoSE);
    System.out.println("Es indígena: " + (esIndigena ? "Sí" : "No"));
    System.out.println("Puntaje PAES: " + puntajePaes);
    System.out.println("Carrera en curso: " + carreraEnCurso);
    System.out.println("Titulado: " + (titulado ? "Sí" : "No"));
}
 else {
            mostrarDetalles(); // Llama al método original
        }
    }
    
    
    //METODO toString
    @Override
    public String toString() {
        return "Postulante: " + nombre + " " + apellido + " | RUT: " + rut;
    }
}

