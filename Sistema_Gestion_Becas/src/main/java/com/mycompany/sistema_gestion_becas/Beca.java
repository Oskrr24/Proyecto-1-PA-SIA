package com.mycompany.sistema_gestion_becas;
import java.util.*;

public class Beca {
    private int id;                  // ID único de la beca
    private String nombre;           // Nombre de la beca
    private String descripcion;      // Descripción de la beca
    private String requisitos;       // Requisitos de la beca (se puede modificar a una lista si lo prefieres)
    private String monto;            // Monto de la beca (en dinero)
    private String duracion;            // Duración de la beca (en meses, por ejemplo)
    private int puntajePaesMinimo;   // Puntaje PAES mínimo requerido
    
    private ArrayList<Solicitud> solicitud;
    
    // Constructor
    public Beca(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.monto = monto;
        this.duracion = duracion;
        this.puntajePaesMinimo = puntajePaesMinimo;
        
        this.solicitud = new ArrayList<>();
    }
    
    
    
    public boolean cumpleRequisitos(Postulante postulante) {
        // Requisitos básicos, pueden ser extendidos en las subclases
        return postulante.getPuntajePaes() >= this.puntajePaesMinimo;
    }
    
    
    //1
    public static  class BecaExcelenciaAcademica extends Beca {

    public BecaExcelenciaAcademica(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Promedio de notas >= 6.0, PAES >= 600, pertenecer al 80% de menores ingresos
        return super.cumpleRequisitos(postulante) 
                && postulante.getNotasMedia() >= 6.0 
                && postulante.getRangoSE() <= 80;
    }
}

    //2
    public static class BecaBAES extends Beca {

    public BecaBAES(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Pertenecer al 60% de menores ingresos, ser beneficiario de alguna beca estatal o gratuidad
        return postulante.getRangoSE() <= 60;
    }
}

    //3
    public static class BecaArticulacion extends Beca {

    public BecaArticulacion(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Promedio de notas >= 5.0, pertenecer al 70% de menores ingresos, estar titulado en carrera técnica
        return postulante.getNotasMedia() >= 5.0 
                && postulante.getRangoSE() <= 70
                && postulante.getTitulado();
    }
}

    //4
    public static class BecaBicentenario extends Beca {

    public BecaBicentenario(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Pertenecer al 70% de menores ingresos, nacionalidad chilena
        return postulante.getRangoSE() <= 70 && postulante.getNacionalidadChilena();
    }
}

    //5
    public static class BecaJuanGomezMillas extends Beca {

    public BecaJuanGomezMillas(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // PAES >= 510, pertenecer al 70% de menores ingresos
        return super.cumpleRequisitos(postulante) 
                && postulante.getRangoSE() <= 70;
    }
}

    //6
    public static class BecaVocacionProfesor extends Beca {

    public BecaVocacionProfesor(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // PAES >= 600, estar matriculado en pedagogía
        return super.cumpleRequisitos(postulante) 
                && "Pedagogía".equalsIgnoreCase(postulante.getCarreraEnCurso());
    }
}

    //7
    public static class BecaNuevoMilenio extends Beca {

    public BecaNuevoMilenio(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Promedio de notas >= 5.0, pertenecer al 70% de menores ingresos
        return postulante.getNotasMedia() >= 5.0 
                && postulante.getRangoSE() <= 70;
    }
}

    //8
    public static class BecaIndigena extends Beca {
        public BecaIndigena(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
            super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
        }

        @Override
        public boolean cumpleRequisitos(Postulante postulante) {
            return postulante.getEsIndigena() && postulante.getRangoSE() <= 60;
        }
    }
    
    //9
    public static class BecaPresidenteRepublica extends Beca {

    public BecaPresidenteRepublica(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Promedio de notas >= 6.0, pertenecer al 60% de menores ingresos
        return postulante.getNotasMedia() >= 6.0 
                && postulante.getRangoSE() <= 60;
    }
}

    //10
    public static class BecaDistincionTrayectoriasEducativas extends Beca {

    public BecaDistincionTrayectoriasEducativas(int id, String nombre, String descripcion, String requisitos, String monto, String duracion, int puntajePaesMinimo) {
        super(id, nombre, descripcion, requisitos, monto, duracion, puntajePaesMinimo);
    }

    @Override
    public boolean cumpleRequisitos(Postulante postulante) {
        // Obtener Distinción a las Trayectorias Educativas en la PAES, estar dentro del 80% de menores ingresos
        return postulante.getEsIndigena() && postulante.getNacionalidadChilena()
                && postulante.getRangoSE() <= 80;
    }
}

    
    
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPuntajePaesMinimo() {
        return puntajePaesMinimo;
    }

    public void setPuntajePaesMinimo(int puntajePaesMinimo) {
        this.puntajePaesMinimo = puntajePaesMinimo;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitud;
    }
    
    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitud = solicitudes;
    }
    
    public void agregarSolicitud(Solicitud solicitud) {
        this.solicitud.add(solicitud);
    }
    
    // Método toString para mostrar los detalles de la beca
    @Override
    public String toString() {
        return "Beca: " + nombre + "\n" +
               "Descripción: " + descripcion + "\n" +
               "Requisitos: " + requisitos + "\n" +
               "Monto: $" + monto + "\n" +
               "Duración: " + duracion + " meses\n" +
               "Puntaje PAES mínimo: " + puntajePaesMinimo;
    }
}

    
