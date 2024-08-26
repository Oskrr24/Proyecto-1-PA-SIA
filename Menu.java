import java.util.*;
//import java.util.HashMap;

class Menu {
    private static Scanner sc = new Scanner(System.in);
    private int opcion;
    
    public void show(){
        
        System.out.println("Bienvenido al Sistema de Gestión de Becas");
        System.out.println("¿Qué desea hacer?");

        System.out.println("1) Consultar Becas disponibles");
        System.out.println("2) Realizar postulación");
        System.out.println("3) Consultar estado de Beca(s)");
        System.out.println("4) Realizar Ficha");
        System.out.println("5) Salir del programa"); 

        opcion = ingresarNumeroValido(sc, 1, 5);
        
        do{
            switch (opcion) {
                case 1:
                    System.out.println("Ha elegido la opción 1");
                    //Método verBecas(input)
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
    
    public void verBecas(){
        System.out.println("Becas disponibles:");
        //Mostrar becas
        //mostrar requisitos de las becas
        
    }

    public void crearFicha(){

        Object[] persona1 = new Object[5];
        Object[] persona2 = new Object[5];
        Object[] persona3 = new Object[5];

        persona1[0] = "Pedro";
        persona1[1] = "González";
        persona1[2] = "12345678-9"; 
        persona1[3] = 17; 

        persona2[0] = "María";
        persona2[1] = "Gallardo";
        persona2[2] = "98765432-1"; 
        persona2[3] = 19; 

        persona2[0] = "Juan";
        persona2[1] = "Ruiz";
        persona2[2] = "91231232-k"; 
        persona2[3] = 18; 
        



        System.out.println("Crear ficha");
        System.out.print("Ingrese los siguientes datos:");
        System.out.print("Nombre:");
        System.out.print("Apellido:");
        System.out.print("Edad:");
        
        
        }    
}
    


