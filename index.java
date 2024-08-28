//import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
//import java.util.ArrayList;
import java.io.*;

public class index{

    private static Scanner sc = new Scanner(System.in);
    private static int opcion;
    private static Postulante postulante1;
    static HashMap<String, Postulante> MapaPostulantes;
    public static void main(String[] args){

        MapaPostulantes = new HashMap<>();
        menu(sc);

    }

    public static void menu(Scanner sc){
        do{
            System.out.println("Bienvenido al Sistema de Gestión de Becas");
            System.out.println("¿Qué desea hacer?");

            System.out.println("VERSIÓN DEL POSTULANTE");
            System.out.println("1) Consultar Becas disponibles");
            System.out.println("2) Realizar postulación"); //LA BECA SE AGREGA AL ARRAY DE LA TABLA, PERO QUEDA COMO EN FALSE HASTA QUE SE APRUEBE
            System.out.println("3) Consultar estado de Beca(s)");
            System.out.println("4) Realizar Ficha/Registrarse"); //AGREGAR A LA TABLA HASH
            
            System.out.println("-------------");

            System.out.println("VERSION DEL ADMINISTRADOR");
            System.out.println("5) Gestionar solicitudes");
            System.out.println("6) Salir del programa"); 

            opcion = ingresarNumeroValido(sc, 1, 6);
            switch (opcion) {
                case 1:
                    clearScreen();
                    System.out.println("Ha elegido la opción 1");
                    mostrarBecas();
                    break;
            
                case 2:
                   System.out.println("Ha elegido la opción 2");
                    //Método realizarPostulacion(input)
                    break;

                case 3:
                //Método consultarBeca(input)
                    System.out.println("Ha elegido la opción 3");

                    break;
                case 4:
                //Método crearFicha(input)
                    break;
                case 5:
                    System.out.println("Ha elegido la opción 5");
                    //Método gestionarSol(input)
                break;

                case 6: 
                    clearScreen();
                    System.out.println("Ha elegido la opción 6");
                    System.out.println("Saliendo del programa...");
                    System.exit(1);
                break;
            }

        }while(opcion != 5);
    }

    public static int ingresarNumeroValido(Scanner input, int min, int max){
        int numero;
        while(true){
            try{
                System.out.print("Ingrese una opción (" + min + "-" + max + "): ");
                String inputStr = input.nextLine();
                numero = Integer.parseInt(inputStr);

                if(numero >= min && numero <= max) {return numero;}

                else{System.out.println("Ingrese un número válido. ("+ min +"-"+ max +")");}
            }catch (NumberFormatException e){
                System.out.println("Por favor ingrese un número válido");
            }
        }

    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void mostrarBecas(){
        clearScreen();
        imprimirDesdeArchivo("information.txt");
        /*IBECAS ACTUALES
        BECA BICENTENARIO
        BECA JUAN GOMEZ MILLAS
        */
    }
    
    public static void imprimirDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void crearFicha(Scanner input){
        postulante1 = new Postulante("Juan", "Perez", 19, "21672971-5", 1, 5.0, true, 70.0, false, 600, "ninguna", false);
        //METER POSTULANTE AL MAPA Y EVALUAR
    }
}  