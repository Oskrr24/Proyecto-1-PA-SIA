import java.util.*;

class Menu {
    private static Scanner sc = new Scanner(System.in);

    public void show(){
        int opcion;
        System.out.println("Bienvenido al Sistema de Gestión de Becas");
        System.out.println("¿Qué desea hacer?");

        System.out.println("1) Consultar Becas disponibles");
        System.out.println("2) Realizar postulación");
        System.out.println("3) Consultar estado de Beca(s)");
        System.out.println("4) Salir del programa"); 

        opcion = ingresarNumeroValido(sc, 1, 4);
        
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
                    System.out.println("Ha elegido la opción 4");
                    System.out.println("Saliendo del programa...");
                break;
            }

        }while(opcion != 4);

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
                System.out.println("Por facor ingrese un número válido");
            }
        }

    }
}
