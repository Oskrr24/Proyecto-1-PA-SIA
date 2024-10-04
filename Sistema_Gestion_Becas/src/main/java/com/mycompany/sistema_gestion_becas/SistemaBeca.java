package com.mycompany.sistema_gestion_becas;
import com.mycompany.sistema_gestion_becas.Beca.BecaIndigena;
import com.mycompany.sistema_gestion_becas.Beca.BecaExcelenciaAcademica;
import com.mycompany.sistema_gestion_becas.Beca.BecaBAES;
import com.mycompany.sistema_gestion_becas.Beca.BecaArticulacion;
import com.mycompany.sistema_gestion_becas.Beca.BecaBicentenario;
import com.mycompany.sistema_gestion_becas.Beca.BecaJuanGomezMillas;
import com.mycompany.sistema_gestion_becas.Beca.BecaVocacionProfesor;
import com.mycompany.sistema_gestion_becas.Beca.BecaNuevoMilenio;
import com.mycompany.sistema_gestion_becas.Beca.BecaPresidenteRepublica;
import com.mycompany.sistema_gestion_becas.Beca.BecaDistincionTrayectoriasEducativas;

import java.io.*;
import java.util.*;

public class SistemaBeca {
    
    private Map<Integer, Beca> mapaBecas;
    private ArrayList<Postulante> listaGeneralPostulantes;
    
    public SistemaBeca(){
        this.mapaBecas = new HashMap<>();
        this.listaGeneralPostulantes = new ArrayList<>();
    }
    
    public ArrayList getListaPostulantes(){
        return this.listaGeneralPostulantes;
    }
     
    //POSTULANTES
    
    public void registrarPostulante() {
    Postulante nuevoPostulante = Postulante.crearPostulante();
    
    if (nuevoPostulante != null) {
        try {
            // Llamamos al método que verifica si el postulante ya existe
            verificarPostulanteDuplicado(nuevoPostulante);
            // Si no lanza excepción, agregamos el postulante
            listaGeneralPostulantes.add(nuevoPostulante);
            System.out.println("Postulante registrado exitosamente.");
        } catch (PostulanteDuplicadoException e) {
            System.out.println(e.getMessage());
        }
    } else {
        System.out.println("No se pudo registrar el postulante. Inténtelo de nuevo.");
    }
}

    // Método que verifica si el postulante ya está registrado
    private void verificarPostulanteDuplicado(Postulante nuevoPostulante) throws PostulanteDuplicadoException {
        for (Postulante postulante : listaGeneralPostulantes) {
            if (postulante.getRut().equals(nuevoPostulante.getRut())) {
                throw new PostulanteDuplicadoException("El postulante con RUT " + nuevoPostulante.getRut() + " ya está registrado.");
            }
        }
    }
    
    public void mostrarPostulantes() {
    if (listaGeneralPostulantes.isEmpty()) {
        System.out.println("No hay postulantes registrados.");
    } else {
        int contador = 1;
        for (Postulante postulante : listaGeneralPostulantes) {
            System.out.println(contador + ". " + postulante);
            contador++;
        }
    }
}
    
    //ELIMINAR POSTULANTE POR RUT O NOMBRE --> CREAR SOBRECARGA
    public boolean eliminarPostulante(String rut) throws PostulanteNoEncontradoException {
    for (Postulante postulante : listaGeneralPostulantes) {
        if (postulante.getRut().equals(rut)) {
            listaGeneralPostulantes.remove(postulante);
            System.out.println("Postulante con RUT " + rut + " eliminado.");
            return true;
        }
    }
    // Si no se encuentra el postulante, lanzamos la excepción
    throw new PostulanteNoEncontradoException("No se encontró ningún postulante con el RUT " + rut);
}
     
    public boolean eliminarPostulante(String nombre, String apellido) {
    for (Postulante postulante : listaGeneralPostulantes) {
        if (postulante.getNombre().equalsIgnoreCase(nombre) && postulante.getApellido().equalsIgnoreCase(apellido)) {
            listaGeneralPostulantes.remove(postulante);
            System.out.println("Postulante " + nombre + " " + apellido + " eliminado.");
            return true;
        }
    }
    System.out.println("No se encontró ningún postulante con el nombre " + nombre + " y apellido " + apellido);
    return false;  // Retorna false si no se encuentra el postulante
}

    public void modificarPostulante() {
    if (listaGeneralPostulantes.isEmpty()) {
        System.out.println("No hay postulantes registrados.");
    } else {
        Scanner scanner = new Scanner(System.in);
        mostrarPostulantes();  // Mostrar la lista de postulantes enumerados

        // Seleccionar el postulante a modificar
        System.out.println("Ingrese el número del postulante que desea modificar:");
        int indice = scanner.nextInt();

        // Validar que el índice esté dentro del rango
        if (indice > 0 && indice <= listaGeneralPostulantes.size()) {
            Postulante postulanteSeleccionado = listaGeneralPostulantes.get(indice - 1);  // Obtener el postulante

            // Modificar atributos del postulante
            System.out.println("Ingrese el nuevo nombre (anterior: " + postulanteSeleccionado.getNombre() + "):");
            String nuevoNombre = scanner.next();
            postulanteSeleccionado.setNombre(nuevoNombre);

            System.out.println("Ingrese el nuevo apellido (anterior: " + postulanteSeleccionado.getApellido() + "):");
            String nuevoApellido = scanner.next();
            postulanteSeleccionado.setApellido(nuevoApellido);

            System.out.println("Ingrese la nueva edad (anterior: " + postulanteSeleccionado.getEdad() + "):");
            int nuevaEdad = scanner.nextInt();
            postulanteSeleccionado.setEdad(nuevaEdad);

            System.out.println("Ingrese el nuevo RUT (anterior: " + postulanteSeleccionado.getRut() + "):");
            String nuevoRut = scanner.next();
            postulanteSeleccionado.setRut(nuevoRut);

            System.out.println("Ingrese el nuevo sexo (1 = Masculino, 2 = Femenino, anterior: " + postulanteSeleccionado.getSexo() + "):");
            int nuevoSexo = scanner.nextInt();
            postulanteSeleccionado.setSexo(nuevoSexo);

            System.out.println("Ingrese la nueva nota media (anterior: " + postulanteSeleccionado.getNotasMedia() + "):");
            float nuevaNotaMedia = scanner.nextFloat();
            postulanteSeleccionado.setNotasMedia(nuevaNotaMedia);

            System.out.println("¿Es de nacionalidad chilena? (true/false, anterior: " + postulanteSeleccionado.getNacionalidadChilena() + "):");
            boolean nuevaNacionalidadChilena = scanner.nextBoolean();
            postulanteSeleccionado.setNacionalidadChilena(nuevaNacionalidadChilena);

            System.out.println("Ingrese el nuevo rango socioeconómico (anterior: " + postulanteSeleccionado.getRangoSE() + "):");
            int nuevoRangoSE = scanner.nextInt();
            postulanteSeleccionado.setRangoSE(nuevoRangoSE);

            System.out.println("¿Es indígena? (true/false, anterior: " + postulanteSeleccionado.getEsIndigena() + "):");
            boolean nuevoEsIndigena = scanner.nextBoolean();
            postulanteSeleccionado.setEsIndigena(nuevoEsIndigena);

            System.out.println("Ingrese el nuevo puntaje PAES (anterior: " + postulanteSeleccionado.getPuntajePaes() + "):");
            int nuevoPuntajePaes = scanner.nextInt();
            postulanteSeleccionado.setPuntajePaes(nuevoPuntajePaes);

            System.out.println("Ingrese la nueva carrera en curso (anterior: " + postulanteSeleccionado.getCarreraEnCurso() + "):");
            String nuevaCarrera = scanner.next();
            postulanteSeleccionado.setCarreraEnCurso(nuevaCarrera);

            System.out.println("¿Está titulado? (true/false, anterior: " + postulanteSeleccionado.getTitulado() + "):");
            boolean nuevoTitulado = scanner.nextBoolean();
            postulanteSeleccionado.setTitulado(nuevoTitulado);

            System.out.println("Postulante modificado exitosamente.");
        } else {
            System.out.println("Índice no válido.");
        }
    }
}
    
    //BECAS
    public void leerBecasDesdeCSV() {
    String archivoCSV = "/BecasDisponibles.csv"; // Ruta relativa

    try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(archivoCSV)))) {
        String linea;

        // Omitir la primera línea (encabezados)
        br.readLine(); // Lee y descarta la primera línea

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length < 7) { // Asegurarse de que hay suficientes datos
                System.out.println("Datos insuficientes en la línea: " + linea);
                continue;
            }

            try {
                int id = Integer.parseInt(datos[0].trim());        // ID de la beca
                String nombre = datos[1].trim();                   // Nombre de la beca
                String descripcion = datos[2].trim();              // Descripción de la beca
                String requisitos = datos[3].trim();               // Requisitos
                String monto = datos[4].trim();                    // Monto de la beca
                String duracion = datos[5].trim();                 // Duración en meses/años
                int puntajePaesMinimo = Integer.parseInt(datos[6].trim()); // Puntaje PAES mínimo
             

                switch (id) {
                    
                    case 1 -> {
                        BecaExcelenciaAcademica beca1 = new BecaExcelenciaAcademica(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca1);
                    }
                    case 2 -> {
                        BecaBAES beca2 = new BecaBAES(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca2);
                    }
                    case 3 -> {
                        BecaArticulacion beca3 = new BecaArticulacion(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca3);
                    }
                    case 4 -> {
                        BecaBicentenario beca4 = new BecaBicentenario(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca4);
                    }
                    case 5 -> {
                        BecaJuanGomezMillas beca5 = new BecaJuanGomezMillas(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca5);
                    }
                    case 6 -> {
                        BecaVocacionProfesor beca6 = new BecaVocacionProfesor(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca6);
                    }
                    case 7 -> {
                        BecaNuevoMilenio beca7 = new BecaNuevoMilenio(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca7);
                    }
                    case 8 -> {
                        BecaIndigena beca = new BecaIndigena(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca);
                    }
                    case 9 -> {
                        BecaPresidenteRepublica beca9 = new BecaPresidenteRepublica(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca9);
                    }
                    case 10 -> {
                        BecaDistincionTrayectoriasEducativas beca10 = new BecaDistincionTrayectoriasEducativas(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
                        mapaBecas.put(id, beca10);
                    }
                    default -> System.out.println("Tipo de beca desconocido: " + id);
                }


            } catch (NumberFormatException e) {
                System.out.println("Error de formato en la línea: " + linea + ". " + e.getMessage());
            }
        }
        System.out.println("Becas leídas correctamente.");
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
    }
}
    
   public void datosIniciales() {
    String filePath = "/entradaDatos.csv";  // Ruta relativa en recursos
    String line = "";
    String csvSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filePath)))) {
        while ((line = br.readLine()) != null) {
            // Dividimos la línea usando split
            String[] datos = line.split(csvSplitBy);

            // Asignamos los valores leídos a los atributos del postulante
            String nombre = datos[0];
            String apellido = datos[1];
            int edad = Integer.parseInt(datos[2]);
            String rut = datos[3];
            int sexo = Integer.parseInt(datos[4]);
            float notasMedia = Float.parseFloat(datos[5]);
            boolean nacionalidadChilena = Boolean.parseBoolean(datos[6]);
            int rangoSE = Integer.parseInt(datos[7]);
            boolean esIndigena = Boolean.parseBoolean(datos[8]);
            int puntajePaes = Integer.parseInt(datos[9]);
            String carreraEnCurso = datos[10];
            boolean titulado = Boolean.parseBoolean(datos[11]);

            // Creamos un nuevo postulante
            Postulante nuevoPostulante = new Postulante(nombre, apellido, edad, rut, sexo, notasMedia, nacionalidadChilena, rangoSE, esIndigena, puntajePaes, carreraEnCurso, titulado);
            
            // Agregamos el postulante a la lista
            listaGeneralPostulantes.add(nuevoPostulante);
        }
        System.out.println("Datos iniciales cargados exitosamente desde el archivo CSV.");
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error en el formato del archivo CSV: " + e.getMessage());
    }
}

    public void filtrarPostulantesBecaYRSE(int idBeca, int rangoMin, int rangoMax) {
    Beca becaSeleccionada = mapaBecas.get(idBeca);
    
    if (becaSeleccionada == null) {
        System.out.println("No se encontró la beca con ID: " + idBeca);
        return;
    }
    
    ArrayList<Solicitud> solicitudes = becaSeleccionada.getSolicitudes();
    if (solicitudes == null || solicitudes.isEmpty()) {
        System.out.println("No hay postulantes para la beca " + becaSeleccionada.getNombre());
        return;
    }
    
    System.out.println("Postulantes para la beca " + becaSeleccionada.getNombre() +
                       " con rango socioeconómico entre " + rangoMin + " y " + rangoMax + ":");
    
    for (Solicitud solicitud : solicitudes) {
        Postulante postulante = solicitud.getPostulante();
        double puntajeSocioeconomico = postulante.getRangoSE();
        
        if (puntajeSocioeconomico >= rangoMin && puntajeSocioeconomico <= rangoMax) {
            System.out.println("Postulante: " + postulante.getNombre() + " " + postulante.getApellido() +
                               " - Puntaje Socioeconómico: " + puntajeSocioeconomico);
        }
    }
}

    public void mostrarBecasDisponibles() {
    if (mapaBecas.isEmpty()) {
        System.out.println("No hay becas disponibles.");
        return;
    }

    System.out.println("Listado de becas disponibles:");
    for (Beca beca : mapaBecas.values()) {
        System.out.println("ID: " + beca.getId() + " - Nombre: " + beca.getNombre());
    }
}

    // Método para mostrar todas las becas y sus postulantes (inicialmente vacío)    
    public void mostrarBecas() {
    for (Map.Entry<Integer, Beca> entry : mapaBecas.entrySet()) {
        Integer idBeca = entry.getKey();
        Beca beca = entry.getValue();

        // Obtener las solicitudes asociadas a esta beca
        ArrayList<Solicitud> solicitudes = beca.getSolicitudes();

        // Mostrar la información de la beca
        System.out.println("ID de Beca: " + idBeca);
        System.out.println("Nombre de la Beca: " + beca.getNombre());
        System.out.println("Descripción: " + beca.getDescripcion());
        System.out.println("Requisitos: " + beca.getRequisitos());
        System.out.println("Monto: $" + beca.getMonto());
        System.out.println("Duración: " + beca.getDuracion() + " meses");
        System.out.println("Puntaje PAES mínimo: " + beca.getPuntajePaesMinimo());

        // Mostrar el número de postulantes
        System.out.println("Número de postulantes: " + (solicitudes != null ? solicitudes.size() : 0));
        System.out.println("------------------------------------");
    }
}
    
    public void eliminarBecaPorId(int idBeca) {
    // Verificar si existe una beca con el ID proporcionado
    if (mapaBecas.containsKey(idBeca)) {
        // Eliminar la beca del mapa
        mapaBecas.remove(idBeca);
        System.out.println("Beca con ID " + idBeca + " eliminada correctamente.");
    } else {
        System.out.println("No se encontró una beca con el ID " + idBeca + ".");
    }
}

    public void postularABeca(String rutPostulante) {
    // Mostrar las becas disponibles
    System.out.println("Becas disponibles:");
    for (Beca beca : mapaBecas.values()) {
        System.out.println("ID: " + beca.getId() + " - " + beca.getNombre());
    }

    // Solicitar la selección de beca al postulante
    System.out.println("Ingrese el ID de la beca a la que desea postular:");
    Scanner scanner = new Scanner(System.in);
    int idBeca = scanner.nextInt();

    // Buscar al postulante en el ArrayList
    Postulante postulante = null;
    for (Postulante p : listaGeneralPostulantes) {
        if (p.getRut().equals(rutPostulante)) {
            postulante = p;
            break;
        }
    }

    if (postulante == null) {
        System.out.println("No se encontró al postulante con RUT: " + rutPostulante);
        return;
    }

    // Buscar la beca seleccionada por su ID directamente en el mapa
    Beca becaSeleccionada = mapaBecas.get(idBeca);

    if (becaSeleccionada == null) {
        System.out.println("No se encontró la beca con ID: " + idBeca);
        return;
    }

    // Obtener la lista de solicitudes de la beca seleccionada
    ArrayList<Solicitud> solicitudes = becaSeleccionada.getSolicitudes();
    if (solicitudes == null) {
        solicitudes = new ArrayList<>();
        becaSeleccionada.setSolicitudes(solicitudes); // Asegurarse de guardar la lista en la beca
    }

    // Verificar si el postulante ya tiene una solicitud aprobada en cualquier beca
    for (Solicitud s : solicitudes) {
        if (s.getPostulante().getRut().equals(rutPostulante) && s.isAprobada()) {
            System.out.println("El postulante " + postulante.getNombre() + " ya tiene una solicitud aprobada para esta beca o para otra beca. No puede volver a postular.");
            return;
        }
    }

    // Verificar si el postulante ya ha postulado a esta beca
    for (Solicitud s : solicitudes) {
        if (s.getPostulante().getRut().equals(rutPostulante)) {
            System.out.println("El postulante " + postulante.getNombre() + " ya ha postulado a la beca " + becaSeleccionada.getNombre() + ".");
            return;
        }
    }

    // Crear una nueva solicitud ya que no ha postulado ni tiene aprobada ninguna beca
    Solicitud nuevaSolicitud = new Solicitud(postulante, idBeca);
    solicitudes.add(nuevaSolicitud);

    System.out.println("El postulante " + postulante.getNombre() + " ha postulado a la beca " + becaSeleccionada.getNombre() + " exitosamente.");
}

    public void mostrarPostulantesPorBeca() {
    if (mapaBecas.isEmpty()) {
        System.out.println("No hay becas ni postulantes registrados.");
        return;
    }

    // Iterar sobre las becas registradas
    for (Map.Entry<Integer, Beca> entry : mapaBecas.entrySet()) {
        Integer idBeca = entry.getKey();
        Beca beca = entry.getValue();
        ArrayList<Solicitud> solicitudes = beca.getSolicitudes();

        System.out.println("ID de Beca: " + idBeca + " - " + beca.getNombre());

        // Mostrar postulantes pendientes
        System.out.println("Postulantes pendientes:");
        boolean hayPendientes = false; // Variable para verificar si hay postulantes pendientes
        if (solicitudes == null || solicitudes.isEmpty()) {
            System.out.println("  No hay postulantes para esta beca.");
        } else {
            for (Solicitud solicitud : solicitudes) {
                if (solicitud.isAprobada() == false) { // Filtrar postulantes no aprobados
                    Postulante postulante = solicitud.getPostulante();
                    System.out.println("  - " + postulante.getNombre() + " " + postulante.getApellido() +
                                       " (RUT: " + postulante.getRut() + ")");
                    hayPendientes = true;
                }
            }
            if (!hayPendientes) {
                System.out.println("  No hay postulantes pendientes para esta beca.");
            }
        }

        // Mostrar postulantes aprobados
        System.out.println("Postulantes aprobados:");
        boolean hayAprobados = false; // Variable para verificar si hay postulantes aprobados
        if (solicitudes == null || solicitudes.isEmpty()) {
            System.out.println("  No hay postulantes para esta beca.");
        } else {
            for (Solicitud solicitud : solicitudes) {
                if (solicitud.isAprobada() == true) { // Filtrar postulantes aprobados
                    Postulante postulante = solicitud.getPostulante();
                    System.out.println("  - " + postulante.getNombre() + " " + postulante.getApellido() +
                                       " (RUT: " + postulante.getRut() + ")");
                    hayAprobados = true;
                }
            }
            if (!hayAprobados) {
                System.out.println("  No hay postulantes aprobados para esta beca.");
            }
        }

        System.out.println(); // Separador entre becas
    }
}
    
    //GESTION DE BECAS
    
    public void gestionarSolicitudes() {
    if (mapaBecas.isEmpty()) {
        System.out.println("No hay becas registradas.");
        return;
    }

    System.out.println("Becas disponibles:");
    for (Map.Entry<Integer, Beca> entry : mapaBecas.entrySet()) {
        Beca beca = entry.getValue();
        System.out.println("ID Beca: " + entry.getKey() + " - " + beca.getNombre());
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione el ID de la beca para gestionar las solicitudes:");
    int idBecaSeleccionada = scanner.nextInt();

    Beca becaSeleccionada = mapaBecas.get(idBecaSeleccionada);
    if (becaSeleccionada == null) {
        System.out.println("No se encontró una beca con el ID proporcionado.");
        return;
    }

    ArrayList<Solicitud> solicitudes = becaSeleccionada.getSolicitudes();
    if (solicitudes.isEmpty()) {
        System.out.println("No hay solicitudes pendientes para esta beca.");
        return;
    }

    System.out.println("Solicitudes pendientes para la beca " + becaSeleccionada.getNombre() + ":");
    for (int i = 0; i < solicitudes.size(); i++) {
        Solicitud solicitud = solicitudes.get(i);
        System.out.println("Solicitud " + (i + 1) + ": " + solicitud.getPostulante().getNombre() +
                           " - RUT: " + solicitud.getPostulante().getRut());
    }

    System.out.println("Seleccione el número de la solicitud a gestionar (1 - " + solicitudes.size() + "):");
    int indiceSolicitud = scanner.nextInt() - 1;

    if (indiceSolicitud < 0 || indiceSolicitud >= solicitudes.size()) {
        System.out.println("Número de solicitud no válido.");
        return;
    }

    Solicitud solicitudSeleccionada = solicitudes.get(indiceSolicitud);

    procesarSolicitud(solicitudSeleccionada, becaSeleccionada, indiceSolicitud, solicitudes);
}

    public void procesarSolicitud(Solicitud solicitudSeleccionada, Beca becaSeleccionada, int indiceSolicitud, ArrayList<Solicitud> solicitudes) {
    Scanner scanner = new Scanner(System.in);

    // Verificar si el postulante cumple con los requisitos de la beca seleccionada
    boolean cumpleRequisitos = becaSeleccionada.cumpleRequisitos(solicitudSeleccionada.getPostulante());

    if (cumpleRequisitos) {
        System.out.println("El postulante " + solicitudSeleccionada.getPostulante().getNombre() + 
                           " cumple con los requisitos de la beca " + becaSeleccionada.getNombre() + ".");

        // Preguntar al administrador si desea aprobar la solicitud
        System.out.println("¿Desea aprobar la solicitud? (si/no):");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("si")) {
            solicitudSeleccionada.setAprobada(true);
            System.out.println("La solicitud ha sido aprobada y el postulante ha sido agregado a la beca " + becaSeleccionada.getNombre() + ".");
        } else {
            System.out.println("La solicitud ha sido rechazada.");
            solicitudes.remove(indiceSolicitud); // Remover la solicitud no aprobada
        }
    } else {
        // Si no cumple con los requisitos, se rechaza automáticamente
        System.out.println("El postulante NO cumple con los requisitos de la beca " + becaSeleccionada.getNombre() + ".");
        System.out.println("La solicitud ha sido rechazada.");
        solicitudes.remove(indiceSolicitud); // Remover la solicitud no aprobada
    }
}

    //GENERACIÓN DEL REPORTE
    public void generarReporteBecas(String nombreArchivo) {
    // Crear un StringBuilder para construir el contenido del archivo
    StringBuilder contenido = new StringBuilder();
    contenido.append("ID Beca,Nombres,Total Postulantes,Total Aprobados,Total Rechazos\n");

    // Recorrer el mapa de becas
    for (Map.Entry<Integer, Beca> entry : mapaBecas.entrySet()) {
        Integer idBeca = entry.getKey();
        Beca beca = entry.getValue();
        ArrayList<Solicitud> solicitudes = beca.getSolicitudes();

        int totalPostulantes = 0;
        int totalAprobados = 0;
        int totalRechazos = 0;

        // Contar postulantes, aprobados y rechazados
        if (solicitudes != null) {
            totalPostulantes = solicitudes.size();
            for (Solicitud solicitud : solicitudes) {
                if (solicitud.isAprobada()) {
                    totalAprobados++;
                } else {
                    totalRechazos++;
                }
            }
        }

        contenido.append(idBeca).append(",")
                  .append(beca.getNombre()).append(",")
                  .append(totalPostulantes).append(",")
                  .append(totalAprobados).append(",")
                  .append(totalRechazos).append("\n");
    }

    // Escribir el contenido en el archivo CSV
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
        writer.write(contenido.toString());
        System.out.println("Reporte generado: " + nombreArchivo);
    } catch (IOException e) {
        System.out.println("Error al escribir el archivo: " + e.getMessage());
    }
}
  
    //METODOS VARIOS
    //METODO PARA QUE EL USUARIO CONTINUE PRESIONANDO UNA TECLA
    public static void presioneTeclaParaContinuar(Scanner input){
        System.out.println("\nPresione una tecla para continuar...");
        input.nextLine();
    }
   
    //METDODO PARA VERIFICAR SI EL NUMERO INGRESADO ES VALIDO
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

}


