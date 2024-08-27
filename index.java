//import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class index{

    private static Scanner sc = new Scanner(System.in);
    private static int opcion;
    static HashMap<String, Postulante> MapaPostulantes;
    public static void main(String[] args){

        MapaPostulantes = new HashMap<>();
        menu(sc);
    }

    public static void menu(Scanner sc){
        do{
            System.out.println("Bienvenido al Sistema de Gestión de Becas");
            System.out.println("¿Qué desea hacer?");

            System.out.println("1) Consultar Becas disponibles");
            System.out.println("2) Realizar postulación");
            System.out.println("3) Consultar estado de Beca(s)");
            System.out.println("4) Realizar Ficha");
            System.out.println("5) Salir del programa"); 
            
            opcion = ingresarNumeroValido(sc, 1, 5);
            switch (opcion) {
                case 1:
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
                    System.out.println("Ha elegido la opción 4");
                    System.out.println("Saliendo del programa...");
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
    
    public static void mostrarBecas(){
        //Imprimir todas todas las 18 becas
    }
    
    
}  