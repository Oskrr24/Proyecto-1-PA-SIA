package paquete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class index{

    private static Scanner sc = new Scanner(System.in);
    private static int opcion;
    private static Postulante postulante1;
    private static HashMap<String, Postulante> mapaPostulantes;
    public static void main(String[] args){

        mapaPostulantes = new HashMap<>();
        menu(sc);

    }

    public static void crearFicha(){
        postulante1 = new Postulante("Juan", "Perez", 19, "21884729-9", 1, 5.0f, true, 70.0f, false, 600, "no", false);

        if(mapaPostulantes.containsKey(postulante1.getRut())){
            System.out.println("Este RUT ya está registrado");
        }
        else{
            mapaPostulantes.put(postulante1.getRut(), postulante1);
            System.out.println("Te has registrado correctamente.");
            //CREAR ARRAYLIST
        }
        mapaPostulantes.put(postulante1.getRut(), postulante1);
        System.out.println();
    }

    public static void realizarPostulacion(){
        System.out.print("Ingrese su RUT: ");
        String rut = sc.nextLine();

        if(mapaPostulantes.containsKey(rut)){
            Postulante postulante = mapaPostulantes.get(rut);
            Becas beca = new Becas();

            System.out.println("Becas disponibles: ");
            imprimirDesdeArchivo("BecasDisponibles.txt"); //REVISAR

            System.out.println("Ingrese índice para postular a la beca: ");
            //HACER OPCIÓN PARA CANCELAR Y DEVOLVERSE
            int opcion = ingresarNumeroValido(sc, 1, 4);

            switch (opcion) {
                case 1:
                    postulante.agregarBeca(beca);
                    System.out.println("Te has postulado a la Beca Bicentenario.");
                    break;
                case 2:
                    postulante.agregarBeca(beca);
                    System.out.println("Te has postulado a la Beca Juan Gómez Millas.");
                    break;
                case 3:
                    postulante.agregarBeca(beca);
                    System.out.println("Te has postulado a la Beca Vocación de Profesor.");
                    break;
                case 4:
                    postulante.agregarBeca(beca);
                    System.out.println("Te has postulado a la Beca Vocación de Profesor.");
                    break;
            }

            //SWITCH CON BECAS, SE SELECCIONA EL NÚMERO DE LA BECA
            //LA POSTULACIÓN SE HACE SI O SI CUMPLE O NO LOS REQUISITOS
            //UNO LUEGO COMO ADMINISTRADOR APRUEBA/RECHAZA LA POSTULACIÓN

            /*
                OPCIONES PARA EL ADMINISTRADOR
            if(beca.BECA_Bicentenario(postulante.getRangoSE(), postulante.getPuntajePaes())){
                postulante.agregarBeca(beca);
                System.out.println("Te has postulado a la Beca Bicentenario.");
            }
            
            if(beca.BECA_JuanGomezMillas(postulante.getRangoSE(), postulante.getPuntajePaes())){
                postulante.agregarBeca(beca);
                System.out.println("Te has postulado a la Beca Juan Gómez Millas.");
            }

            if(beca.BECA_Profesor_licenciado_profesional(postulante.getCarreraEnCurso(), postulante.getTitulado())){
                postulante.agregarBeca(beca);
                System.out.println("Te has postulado a la Beca Vocación de Profesor.");
            }

            if(beca.BECA_ExcelenciaAcadémica(postulante.getRangoSE(), postulante.getNotasMedia())){
                postulante.agregarBeca(beca);
                System.out.println("Te has postulado a la Beca Vocación de Profesor.");
            }*/

        } else System.out.println("No se encontró un postulante con este RUT. ");

    }

    public static void mostrarBecasPostulado(){
        System.out.print("Ingresa su RUT para ver tus becas: ");
        String rut = sc.nextLine();

        if(mapaPostulantes.containsKey(rut)){
            Postulante postulante = mapaPostulantes.get(rut);
            ArrayList<Becas> becas = postulante.getBecas();

            if(becas.isEmpty()){
                System.out.println("No has postulado a ninguna beca");
            }else{
                System.out.println("Becas postuladas: ");
                for(Becas beca : becas){
                    System.out.println("- " + beca.getClass().getSimpleName());
                }
            }
        }
    }

    public static void menu(Scanner sc){
        do{
            clearScreen();
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
            System.out.println("7) MOSTRAR BECAS (PUEBA)");

            opcion = ingresarNumeroValido(sc, 1, 7);
            switch (opcion) {
                case 1:
                    clearScreen();
                    System.out.println("Ha elegido la opción 1");
                    mostrarBecas();
                    break;
            
                case 2:
                   System.out.println("Ha elegido la opción 2");
                    realizarPostulacion();
                    break;

                case 3:
                //Método consultarBeca(input)
                    System.out.println("Ha elegido la opción 3");

                    break;
                case 4:
                    clearScreen();
                    crearFicha();
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

                case 7:
                    mostrarBecasPostulado();
                    break;
            }
            presioneTeclaParaContinuar(sc);
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
        clearScreen();
        imprimirDesdeArchivo("information.txt");
        /*IBECAS ACTUALES
        BECA BICENTENARIO
        BECA JUAN GOMEZ MILLAS
        BECA VOCACIÓN PROFESOR
        BECA EXCELENCIA ACADÉMICA (BEA)
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
    
    public static void presioneTeclaParaContinuar(Scanner input){
        System.out.println("\nPresione una tecla para continuar...");
        input.nextLine();
    }
}  