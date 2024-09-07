package paquete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

/*POR HACER:
 Modificar el método agregar beca para que no se agreguen repetidos
 
*/

public class index{

    private static Scanner sc = new Scanner(System.in);
    private static int opcion;
    private static Postulante postulante1;
    //private static Postulante postulante2;
    private static HashMap<String, Postulante> mapaPostulantes;
    public static void main(String[] args){

        mapaPostulantes = new HashMap<>();
        menu(sc);

    }

    public static void crearFicha(){
        postulante1 = new Postulante("Juan", "Perez", 19, "21884729-9", 1, 5.0f, true, 70.0f, false, 600, "no", false);
        //postulante2 = new Postulante("Daniela", "Vega", 18, "21914929-K", 2, 6.5f, true, 70.0f, false, 850, "no", false);
    
        if(mapaPostulantes.containsKey(postulante1.getRut()) /*|| mapaPostulantes.containsKey(postulante2.getRut())*/){
            System.out.println("Este RUT ya está registrado");
        }
        else{
            mapaPostulantes.put(postulante1.getRut(), postulante1);
            //mapaPostulantes.put(postulante2.getRut(), postulante2);
    
            System.out.println("Te has registrado correctamente.");
        }
        System.out.println();
    }
    

    public static void realizarPostulacion(){
        System.out.print("Ingrese su RUT: ");
        String rut = sc.nextLine();
    
        if(mapaPostulantes.containsKey(rut)){
            Postulante postulante = mapaPostulantes.get(rut);
    
            System.out.println("Becas disponibles: ");
            imprimirDesdeArchivo("BecasDisponibles.txt");
    
            System.out.println("Ingrese índice para postular a la beca: ");
            int opcion = ingresarNumeroValido(sc, 1, 4);
    
            String nombreBeca = "";
            switch (opcion) {
                case 1:
                    nombreBeca = "Beca Bicentenario";
                    break;
                case 2:
                    nombreBeca = "Beca Juan Gómez Millas";
                    break;
                case 3:
                    nombreBeca = "Beca Vocación de Profesor";
                    break;
                case 4:
                    nombreBeca = "Beca Excelencia Académica";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
    
            boolean yaPostulado = false;
            for (Becas beca : postulante.getBecas()) {
                if (beca.getNombreBeca().equals(nombreBeca)) {
                    yaPostulado = true;
                    break;
                }
            }
    
            if (yaPostulado) {
                System.out.println("Ya has postulado a la " + nombreBeca + ".");
            } else {
                postulante.agregarBeca(new Becas(nombreBeca));
                System.out.println("Te has postulado a la " + nombreBeca + ".");
            }
    
        } else {
            System.out.println("No se encontró un postulante con este RUT.");
        }
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

                for (Becas beca : becas) {
                    System.out.println("- " + beca.getNombreBeca());
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
            System.out.println("2) Consultar Becas Postuladas");
            System.out.println("3) Realizar postulación"); //LA BECA SE AGREGA AL ARRAY DE LA TABLA, PERO QUEDA COMO EN FALSE HASTA QUE SE APRUEBE
            System.out.println("4) Consultar estado de Beca(s)");// UNICA Q NO FUNCIONA
            System.out.println("5) Realizar Ficha/Registrarse"); //AGREGAR A LA TABLA HASH
            
            System.out.println("-------------");

            System.out.println("VERSION DEL ADMINISTRADOR");
            System.out.println("6) Gestionar solicitudes"); //FUNCIONA
            System.out.println("7) Salir del programa"); 

            opcion = ingresarNumeroValido(sc, 1, 7);
            switch (opcion) {
                case 1:
                    clearScreen();
                    System.out.println("Ha elegido la opción 1");
                    mostrarBecas();
                    break;
            
                case 2:
                    clearScreen();
                    System.out.println("Ha elegido la opción 2");
                    mostrarBecasPostulado();
                    break;

                case 3:
                    clearScreen();
                    System.out.println("Ha elegido la opción 3");
                    realizarPostulacion();
                    break;

                case 4:
                    //Método consultarBeca(input)
                    System.out.println("Ha elegido la opción 4");

                    break;
                case 5:
                    clearScreen();
                    System.out.println("Ha elegido la opción 5");
                    crearFicha();
                    break;
                case 6:
                    System.out.println("Ha elegido la opción 6");
                    //Método gestionarSol(input)
                    break;

                case 7: 
                    clearScreen();
                    System.out.println("Ha elegido la opción 7");
                    System.out.println("Saliendo del programa...");
                    System.exit(1);
                    break;

            }
            presioneTeclaParaContinuar(sc);
        }while(opcion != 7);
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
        System.out.println("Escoja el método para mostrar Becas:");
        System.out.println("1) Mostrar todas las becas");
        System.out.println("2) Filtrar por puntaje PAES");

        int opcion = ingresarNumeroValido(sc, 1, 2);

        if(opcion == 1){
            imprimirDesdeArchivo("information.txt");
        }else{
            System.out.print("Ingrese el puntaje mínima a filtrar (100 - 1000): ");
            int puntajePaes = sc.nextInt();
            imprimirDesdeArchivo("information.txt", puntajePaes);
            //System.exit(0);
        }
        
        /*IBECAS ACTUALES
        BECA BICENTENARIO
        BECA JUAN GOMEZ MILLAS
        BECA VOCACIÓN PROFESOR
        BECA EXCELENCIA ACADÉMICA (BEA)
        */
    }
    
    public static void imprimirDesdeArchivo(String archivo, int pPaes) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            StringBuilder becaActual = new StringBuilder();
            boolean agregarBeca = false;

            while ((linea = br.readLine()) != null) {
                // Si encontramos una línea en blanco, es el fin de una beca, evaluamos si la agregamos
                if (linea.trim().isEmpty()) {
                    if (agregarBeca) {
                        System.out.println(becaActual.toString().trim());
                    }
                    becaActual.setLength(0);  // Reiniciamos el StringBuilder
                    agregarBeca = false;  // Reiniciamos el flag
                } else {
                    becaActual.append(linea).append("\n");

                    // Verificamos si la línea contiene el puntaje PAES
                    if (linea.contains("Puntaje PAES")) {
                        // Aquí asumimos que la línea contiene algo como "Puntaje PAES 510 puntos"
                        String[] partes = linea.split(" ");
                        for (String parte : partes) {
                            try {
                                int puntaje = Integer.parseInt(parte.trim());
                                if (puntaje >= pPaes) {
                                    agregarBeca = true;
                                }
                            } catch (NumberFormatException e) {
                                // Si no es un número, ignoramos esta parte
                            }
                        }
                    }
                }
            }

            // Para la última beca en el archivo (si no termina con una línea en blanco)
            if (agregarBeca) {
                System.out.println(becaActual.toString().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        presioneTeclaParaContinuar(sc);
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
