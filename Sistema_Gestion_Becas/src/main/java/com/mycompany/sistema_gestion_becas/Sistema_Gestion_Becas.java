package com.mycompany.sistema_gestion_becas;
import java.util.*;

/**
 * @author Grupo 31
 */
public class Sistema_Gestion_Becas {

    private static Scanner sc = new Scanner(System.in);
    private static SistemaBeca sistema = new SistemaBeca();
    
    public static void main(String[] args){
        menu(sc);
    }

    //MENÚ
    public static void menu(Scanner sc){
        int opcion;
        sistema.datosIniciales();
        
        sistema.leerBecasDesdeCSV();
     do{
         
         System.out.println("-------------------------------------------");
         System.out.println("Bienvenido al Sistema de Gestión de Becas");
         System.out.println("¿Qué desea hacer?");
         
         System.out.println("VERSIÓN DEL POSTULANTE");
         System.out.println("1) Consultar Becas disponibles");
         System.out.println("2) Registrarse"); 
         System.out.println("3) Solicitar Postulacion"); 
        
         System.out.println("-------------");

         System.out.println("VERSION DEL ADMINISTRADOR");
         System.out.println("4) Mostrar postulantes "); 
         System.out.println("6) Eliminar postulante (por rut)"); 
         System.out.println("7) Eliminar postulante (por nombre y apellido)"); 
         System.out.println("8) Eliminar Beca "); 
         System.out.println("9) Filtrar Postulantes por Beca y rango Socio-Económico"); 
         System.out.println("10) Mostrar Becas y Postulantes "); 
         System.out.println("11) Gestionar solicitudes "); 
         System.out.println("12) Mostrar detalles de postulante");
         System.out.println("13) Generar reporte de Becas "); 
         
         System.out.println("14) Salir del programa"); 

         opcion = sistema.ingresarNumeroValido(sc, 1, 14);
         switch (opcion) {
             case 1 -> {
                 
                 System.out.println("Ha elegido la opción 1");
                 sistema.mostrarBecas();
             }

             case 2 -> {
                 
                 System.out.println("Ha elegido la opción 2");
                 sistema.registrarPostulante();
             }
             case 3 -> {
                 
                 System.out.println("Ha elegido la opción 3");
                 System.out.print("Ingrese el rut del postulante parar postular: ");
                 String rut = sc.nextLine();
                 sistema.postularABeca(rut);
             }
             case 4 -> {
                System.out.println("Ha elegido la opción 4");
                sistema.mostrarPostulantes();
                }
            
             case 6 -> {
                System.out.println("Ha elegido la opción 6");
                System.out.print("Ingrese el rut del postulante a eliminar: ");
                String rut = sc.nextLine();
                sistema.eliminarPostulante(rut);
                }
             case 7 -> {
                System.out.println("Ha elegido la opción 7");
                System.out.print("Ingrese el nombre del postulante a eliminar: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el apellido del postulante a eliminar: ");
                String apellido = sc.nextLine();
                sistema.eliminarPostulante(nombre, apellido);
                }
             
             case 8 -> {
                System.out.println("Ha elegido la opción 8");
                System.out.print("Ingrese el indice de la beca a eliminar: ");
                int idBeca = sc.nextInt();
                sistema.eliminarBecaPorId(idBeca);
                }
             case 9 -> {
                System.out.println("Ha elegido la opción 9");
                sistema.mostrarBecasDisponibles();
                System.out.print("Ingrese el id de la beca a filtrar: ");
                int id = sc.nextInt();
                System.out.print("Ingrese el rango minimo a filtrar: ");
                int rangoMin = sc.nextInt();
                System.out.print("Ingrese el rango maximo a filtrar: ");
                int rangoMax = sc.nextInt();
                sistema.filtrarPostulantesBecaYRSE(id, rangoMin, rangoMax);
                }
             case 10 -> {
                System.out.println("Ha elegido la opción 10");
                
                sistema.mostrarPostulantesPorBeca();
                }
             case 11 -> {
                System.out.println("Ha elegido la opción 11");
                
                sistema.gestionarSolicitudes();
                }
             case 12 -> {
                System.out.println("Ha elegido la opción 12");
                System.out.print("Ingrese el N° de postulante a mostrar detalle: ");
                sistema.mostrarPostulantes();
                int indice = sistema.ingresarNumeroValido(sc, 1, sistema.getListaPostulantes().size());
                
                System.out.println("Escoja opcion:");
                System.out.println("1) Ver Nombre, Apellido y Rut");
                System.out.println("2) Ver detalle completo");
                int opcion2 = sc.nextInt();
                Postulante seleccionado = (Postulante) sistema.getListaPostulantes().get(indice);
                
                if(opcion2 == 1){
                    seleccionado.mostrarDetalles();
                }else{
                    seleccionado.mostrarDetalles("completo");
                }
                
                }
             case 13 -> {
                System.out.println("Ha elegido la opción 13");
                sistema.generarReporteBecas("ReporteBecas.csv");
                }
             case 14 -> { 
                
                 System.out.println("Ha elegido la opción 15");
                 System.out.println("Saliendo del programa...");
                 sc.close();
                 System.exit(0);
             }

         }
         SistemaBeca.presioneTeclaParaContinuar(sc);
     }while(opcion != 14);
 }
 
}
    
